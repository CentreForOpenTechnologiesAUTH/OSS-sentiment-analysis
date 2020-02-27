package com.Utilities;


import com.ApiListeners.BugsListener;
import com.ApiListeners.CommentsListener;
import com.ApiListeners.ProductListener;
import com.Hibernate.HibernateUtility;
import com.Models.Entities.*;
import com.Models.InputObjects.BugsObject;
import com.Models.InputObjects.CommentsObject;
import com.Models.InputObjects.ProductObject;
import com.StaticObjects;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This utility is responsible for populating the database
 * with all the necessary data gathered from bugzilla (or any other source)
 */
public class PopulationUtility {
    /**
     * This fetches the specified product with the contained info such as versions,components etc.
     */
    public void getProduct(){
        System.out.println("Searching "+ StaticObjects.baseUrl+" for product "+StaticObjects.product);
        ProductObject.Products products= ProductListener.fetchProduct();
        Session session= HibernateUtility.getSessionFactory().openSession();
        int versionsCount=0;
        int componentsCount=0;
        for (ProductObject.Product product: products.getProducts()) {
            ProductEntity productEntity=new ProductEntity();
            productEntity.setId(product.getId());
            productEntity.setName(product.getName());

            for (ProductObject.Version version : product.getVersions()){
                versionsCount++;
                VersionEntity versionEntity=new VersionEntity();
                versionEntity.setId(version.getId());
                versionEntity.setName(version.getName());
                versionEntity.setIsActive(false);
                productEntity.getVersions().add(versionEntity);
            }
            for(ProductObject.Component component : product.getComponents()){
                componentsCount++;
                ComponentEntity componentEntity=new ComponentEntity();
                componentEntity.setId(component.getId());
                componentEntity.setActive(false);
                componentEntity.setName(component.getName());
                productEntity.getComponents().add(componentEntity);
            }

            session.beginTransaction();
            session.save(productEntity);
            session.getTransaction().commit();
        }
        System.out.println("Found and saved "+products.getProducts().size()+" product(s) with "+
                versionsCount+" versions and "+componentsCount+" components");
        HibernateUtility.shutdown();

    }

    /**
     * temp method to fetch both bugs and comments simultaneously
     */
    public void getBugsWithComments(){
        HashSet<String> systemMail=new HashSet<String>();
        systemMail.add("libreoffice-commits@lists.freedesktop.org");
        systemMail.add("libreoffice-bugs@lists.freedesktop.org");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH);
        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from ProductEntity");
        List<ProductEntity> products=(List<ProductEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("Starting to fetch bugs with comments for all active products versions and comments");
        for (ProductEntity product:products) {
            System.out.println("<===> Getting active components and versions for product :"+product.getName()+" <===>");

            query = session.createQuery("from VersionEntity ve where ve.isActive=:active and ve.product.id=:id");
            query.setParameter("active", true);
            query.setParameter("id",product.getId());
            List<VersionEntity> versions = (List<VersionEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            query = session.createQuery("from ComponentEntity comp where comp.isActive=:active and comp.product.id=:id");
            query.setParameter("active", true);
            query.setParameter("id",product.getId());
            List<ComponentEntity> components = (List<ComponentEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            for (ComponentEntity component : components) {
                System.out.println("--==Fetching bugs for component :" + component.getName() + " across  " + versions.size() + " different versions==--");
                for (VersionEntity version : versions) {
                    int bugIndex=0,commentSum=0;
                    BugsObject.Bugs bugs = BugsListener.fetchBugs(product.getName(), component.getName(), version.getName());
                    if (bugs.getBugs() != null && bugs.getBugs().size() > 0) {
                        System.out.println("Fetching for version "+version.getName());
                        for (BugsObject.Bug bug : bugs.getBugs()) {
                            int blocked=bug.getBlocks()!=null?bug.getBlocks().size():0;
                            int depend_bugs=bug.getDependsOn()!=null?bug.getDependsOn().size():0;
                            boolean duplicate=bug.getDupeOf()!=null?true:false;
                            Date creation_date=new Date();Date last_changed_date=new Date();;
                            try {
                                creation_date= formatter.parse(bug.getCreationTime());
                                last_changed_date=formatter.parse(bug.getLastChangeTime());
                            } catch(Exception ex){
                                System.out.println("Error during parsing date "+bug.getCreationTime()+" or "+bug.getLastChangeTime());
                            }
                            BugEntity bugEntity = new BugEntity(bug.getId(),product,component,version,new HashSet<CommentEntity>(),0,
                                    bug.getAssignedTo(),bug.getCreator(),blocked,depend_bugs,bug.getIsConfirmed(),bug.getIsOpen()
                                    ,creation_date,duplicate,last_changed_date,bug.getOpSys(),bug.getPriority(),
                                    bug.getResolution(),bug.getSeverity(),bug.getStatus()
                            );
                            List<CommentsObject.Comment> comments= CommentsListener.fetchComments(bugEntity.getId());
                            bugIndex++;
                            commentSum+=comments.size();
                            System.out.println("Processing bug number "+bugIndex);
                            System.out.println("Have found "+commentSum+" comments so far");
                            for (CommentsObject.Comment comment:comments) {
                                boolean isBugCreator=bug.getCreator().equalsIgnoreCase(comment.getCreator());
                                boolean isSystem=systemMail.contains(bug.getCreator());
                                Date comment_creation_date=new Date();
                                try {
                                    comment_creation_date= formatter.parse(comment.getCreationTime());
                                } catch(Exception ex){
                                    System.out.println("Error during parsing date "+comment.getCreationTime());
                                }
                                CommentEntity commentEntity =new CommentEntity(comment.getId(),null,comment.getText(),comment.getCount(),
                                        comment_creation_date,comment.getCreator(),isBugCreator,isSystem);
                                bugEntity.getComments().add(commentEntity);
                            }
                            session.beginTransaction();
                            session.save(bugEntity);
                            session.getTransaction().commit();
                        }
                        System.out.println("Found and saved " + bugIndex + " bugs and " + commentSum + " comments !");
                    }

                }

            }
        }
        HibernateUtility.shutdown();
    }

    /**
     * Since this tools was developed to analyze certain LibreOffice components
     * across major versions ,this will activate only those .
     * Alternatively ,other components-versions can be activated (set ACTIVE=1)
     * and fetched/analyzed
     */
    public void autoActivateComponentsVersions(){

        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from ProductEntity");
        List<ProductEntity> products=(List<ProductEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        int activatedComps=0,activatedVersions=0;

        for(ProductEntity product:products){
            query = session.createQuery("from VersionEntity ve where ve.product.id=:id");
            query.setParameter("id",product.getId());
            List<VersionEntity> versions = (List<VersionEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            query = session.createQuery("from ComponentEntity ce where ce.product.id=:id");
            query.setParameter("id",product.getId());
            List<ComponentEntity> components = (List<ComponentEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            List<String> defaultComponents=new ArrayList<String>();
            defaultComponents.add("Writer");
            defaultComponents.add("Calc");
            defaultComponents.add("Draw");
            for(ComponentEntity component:components){
                for (String defComp:defaultComponents) {
                    if(defComp.equalsIgnoreCase(component.getName())){
                        activatedComps++;
                        session.beginTransaction();
                        component.setActive(true);
                        session.update(component);
                        session.getTransaction().commit();
                    }
                }
            }
            for(VersionEntity version:versions){
                if(version.getName().toLowerCase().contains("all version")){
                    activatedVersions++;
                    session.beginTransaction();
                    version.setIsActive(true);
                    session.update(version);
                    session.getTransaction().commit();
                }
            }
        }
        HibernateUtility.shutdown();

    }

    /**
     * This fetches the specified product-version-component triplet's bugs
     */
    public void getBugs(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH);
        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from ProductEntity");
        List<ProductEntity> products=(List<ProductEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("Starting to fetch bugs for all active products, versions and comments");
        int activeVerCount=0;
        int activeCompCount=0;
        int activeProdCount=0;
        int bugsCount=0;
        session.beginTransaction();
        long startTime=System.currentTimeMillis();
        for (ProductEntity product:products) {
            activeProdCount++;
            System.out.println("<===> Getting active components and versions for product :"+product.getName()+" <===>");

            query = session.createQuery("from VersionEntity ve where ve.isActive=:active and ve.product.id=:id");
            query.setParameter("active", true);
            query.setParameter("id",product.getId());
            List<VersionEntity> versions = (List<VersionEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            activeVerCount+=versions.size();

            query = session.createQuery("from ComponentEntity comp where comp.isActive=:active and comp.product.id=:id");
            query.setParameter("active", true);
            query.setParameter("id",product.getId());
            List<ComponentEntity> components = (List<ComponentEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            activeCompCount+=components.size();

            for (ComponentEntity component : components) {
                System.out.println("--==Fetching bugs for component :" + component.getName() + " across  " + versions.size() + " different versions==--");
                for (VersionEntity version : versions) {
                    BugsObject.Bugs bugs = BugsListener.fetchBugs(product.getName(), component.getName(), version.getName());
                    if (bugs!=null && bugs.getBugs() != null && bugs.getBugs().size() > 0) {
                        bugsCount+=bugs.getBugs().size();
                        //System.out.println("Found " + bugs.getBugs().size() + " bugs in version " + version.getName() + " and saving...");
                        for (BugsObject.Bug bug : bugs.getBugs()) {
                            int blocked=bug.getBlocks()!=null?bug.getBlocks().size():0;
                            int depend_bugs=bug.getDependsOn()!=null?bug.getDependsOn().size():0;
                            boolean duplicate=bug.getDupeOf()!=null?true:false;
                            Date creation_date=new Date();Date last_changed_date=new Date();;
                            try {
                                 creation_date= formatter.parse(bug.getCreationTime());
                                 last_changed_date=formatter.parse(bug.getLastChangeTime());
                            } catch(Exception ex){
                                System.out.println("Error during parsing date "+bug.getCreationTime()+" or "+bug.getLastChangeTime());
                            }
                            BugEntity bugEntity = new BugEntity(bug.getId(),product,component,version,new HashSet<CommentEntity>(),0,
                                    bug.getAssignedTo(),bug.getCreator(),blocked,depend_bugs,bug.getIsConfirmed(),bug.getIsOpen()
                                    ,creation_date,duplicate,last_changed_date,bug.getOpSys(),bug.getPriority(),
                                    bug.getResolution(),bug.getSeverity(),bug.getStatus()
                                    );
                            session.save(bugEntity);

                        }
                    }
                }
            }
        }
        long endTime=System.currentTimeMillis();
        session.getTransaction().commit();
        System.out.println("Found and saved "+bugsCount+" bugs across "+activeProdCount+" products ,"+activeCompCount+" components and "
        +activeVerCount+" versions in "+((endTime-startTime)/1000)+" sec");
        HibernateUtility.shutdown();
    }

    /**
     * This fetches the comments associated with all the bugs fetched already
     */
    public void getComments(){
        HashSet<String> systemMail=new HashSet<String>();
        systemMail.add("libreoffice-commits@lists.freedesktop.org");
        systemMail.add("libreoffice-bugs@lists.freedesktop.org");
        systemMail.add("qa-admin@libreoffice.org");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH);
        Session session=HibernateUtility.getSessionFactory().openSession();

        Query query=session.createQuery("from BugEntity");
        List<BugEntity> bugs=(List<BugEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("Found "+bugs.size()+" saved bugs .Fetching comments.");
        session.beginTransaction();
        long startTime=System.currentTimeMillis();
        int commentSum=0;
        int bugIndex=0;
        int bugCompletionIndex=0;
        int bugMax=bugs.size();
        for (BugEntity bug:bugs) {
            bugIndex++;
            bugCompletionIndex++;
            if(((float)bugCompletionIndex/(float)bugMax)*100>10){
                long tempEndTime=System.currentTimeMillis();
                System.out.println("Fetched comments for "+bugIndex+" out of "+bugMax+" bugs ("+commentSum+" comments , elapsed : "+((tempEndTime-startTime)/1000)+" sec)");
                bugCompletionIndex=0;
            }
            List<CommentsObject.Comment> comments= CommentsListener.fetchComments(bug.getId());
            if(comments!=null && comments.size()>0) {
                for (CommentsObject.Comment comment : comments) {
                    commentSum++;
                    boolean isBugCreator = bug.getCreator().equalsIgnoreCase(comment.getCreator());
                    String creator = comment.getCreator().trim();
                    boolean isSystem = false;
                    for (String sysMail : systemMail) {
                        if (sysMail.equalsIgnoreCase(creator)) {
                            isSystem = true;
                        }
                    }
                    Date creation_date = new Date();
                    try {
                        creation_date = formatter.parse(comment.getCreationTime());
                    } catch (Exception ex) {
                        System.out.println("Error during parsing date " + comment.getCreationTime());
                    }
                    CommentEntity commentEntity = new CommentEntity(comment.getId(), bug, comment.getText(), comment.getCount(),
                            creation_date, creator, isBugCreator, isSystem);
                    session.save(commentEntity);
                    if (commentSum % 20 == 0) {
                        session.flush();
                        session.clear();
                    }
                }
            }
        }
        long endTime=System.currentTimeMillis();
        session.getTransaction().commit();
        System.out.println("Found and saved "+commentSum+" comments for the saved bugs in "+((endTime-startTime)/1000)+" sec");
        HibernateUtility.shutdown();
    }
}
