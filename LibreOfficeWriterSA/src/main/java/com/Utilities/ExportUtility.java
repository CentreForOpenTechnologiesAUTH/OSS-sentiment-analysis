package com.Utilities;

import com.Hibernate.HibernateUtility;
import com.Models.Entities.BugEntity;
import com.Models.Entities.CommentEntity;
import com.Models.Entities.CommentMCEntity;
import com.Models.Entities.CommentVaderEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

/**
 * This utility is responsible for exporting all the necessary data and outputs
 * to folders and files for external use
 */
public class ExportUtility {
    public void exportDataVader(){
        System.out.println("Exporting any data analyzed by Vader");
        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from BugEntity");
        List<BugEntity> bugs=(List<BugEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        for (BugEntity bug:bugs) {
            try{
                File csvFile = new File("Output/" + bug.getProduct().getName() + "/" + bug.getComponent().getName() + "/" +bug.getProdVersion().getName()+ "/" + bug.getId() + "_vader.csv");
                if(!csvFile.exists()) {
                    csvFile.getParentFile().mkdirs();
                    csvFile.createNewFile();
                }
                query=session.createQuery("from CommentVaderEntity cve where cve.comment.bug.id=:id");
                query.setParameter("id",bug.getId());
                List<CommentVaderEntity> commentAnalyses=(List<CommentVaderEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
                BufferedWriter pw =new BufferedWriter(new FileWriter(csvFile,true));
                for (CommentVaderEntity commentAnalysis:commentAnalyses) {
                    pw.append(commentAnalysis.getId().toString());
                    pw.append(",");
                    pw.append(String.valueOf(commentAnalysis.getCompound()));
                    pw.append(",");
                    pw.append(String.valueOf(commentAnalysis.getNeutral()));
                    pw.append(",");
                    pw.append(String.valueOf(commentAnalysis.getPositive()));
                    pw.append(",");
                    pw.append(String.valueOf(commentAnalysis.getNegative()));
                    pw.newLine();
                }
                pw.flush();
                pw.close();
            }catch(Exception ex){
                System.out.println("Error during writing to output: "+ex.toString());
            }
        }
    }

    public void exportDataMC(){
        System.out.println("Exporting any data analyzed by Meaning Cloud");
        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from BugEntity");
        List<BugEntity> bugs=(List<BugEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        for (BugEntity bug:bugs) {
            try{
                query=session.createQuery("from CommentMCEntity cmce where cmce.comment.bug.id=:id");
                query.setParameter("id",bug.getId());
                List<CommentMCEntity> commentAnalyses=(List<CommentMCEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
                if(commentAnalyses==null || commentAnalyses.size()==0){
                    continue;
                }
                File csvFile = new File("Output/" + bug.getProduct().getName() + "/" + bug.getComponent().getName() + "/" +bug.getProdVersion().getName()+ "/" + bug.getId() + "_mc.csv");
                if(!csvFile.exists()) {
                    csvFile.getParentFile().mkdirs();
                    csvFile.createNewFile();
                }
                BufferedWriter pw =new BufferedWriter(new FileWriter(csvFile,true));
                for (CommentMCEntity commentMCEntity:commentAnalyses) {
                    pw.append(commentMCEntity.getId().toString());
                    pw.append(",");
                    pw.append(commentMCEntity.getScore());
                    pw.append(",");
                    pw.append(String.valueOf(commentMCEntity.getConfidence()));
                    pw.append(",");
                    pw.append(String.valueOf(commentMCEntity.getSubjectivity().equalsIgnoreCase("SUBJECTIVE")?1:0));
                    pw.append(",");
                    pw.append(String.valueOf(commentMCEntity.getAgreement().equalsIgnoreCase("AGREEMENT")?1:0));
                    pw.append(",");
                    pw.append(String.valueOf(commentMCEntity.getIrony().equalsIgnoreCase("IRONY")?1:0));
                    pw.append(",");
                    pw.append(String.valueOf(commentMCEntity.getSentencesCount()));
                    pw.newLine();
                }
                pw.flush();
                pw.close();
            }catch(Exception ex){
                System.out.println("Error during writing to output: "+ex.toString());
            }
        }
    }

    public void exportDataByBug(){
        System.out.println("Exporting bug scores from related comments");
        DecimalFormat df3 = new DecimalFormat("#.###");
        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from BugEntity");
        List<BugEntity> bugs=(List<BugEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        File csvFile = new File("OutputBugs.csv");
        try {
            if (!csvFile.exists()) {
                csvFile.createNewFile();
            }
            BufferedWriter pw = new BufferedWriter(new FileWriter(csvFile, true));
            for (BugEntity bug : bugs) {
                try {
                    double meanCompound = 0, meanNegative = 0, meanNeutral = 0, meanPositive = 0;
                    double meanAgreement = 0, meanConfidence = 0, meanIrony = 0, meanSubjectivity = 0, meanSentences = 0, meanScore = 0;
                    double countCompound = 0, countNegative = 0, countNeutral = 0, countPositive = 0;
                    double countAgreement = 0, countConfidence = 0, countIrony = 0, countSubjectivity = 0, countSentences = 0;
                    double  countScore = 0;
                    double commsMC = 0, commsVDR = 0;
                    query = session.createQuery("from CommentMCEntity cmce where cmce.comment.system=false and cmce.comment.bug.id=:id");
                    query.setParameter("id", bug.getId());
                    List<CommentMCEntity> commentAnalysesMC = (List<CommentMCEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
                    commentAnalysesMC.size();
                    if (commentAnalysesMC.size() > 0) {
                        for (CommentMCEntity commMC : commentAnalysesMC) {
                            if(commMC==null){
                                continue;
                            }
                            countConfidence+=commMC.getConfidence();
                            countAgreement+=commMC.getAgreement().equalsIgnoreCase("AGREEMENT") ? 1 : 0;
                            countSubjectivity+=commMC.getSubjectivity().equalsIgnoreCase("SUBJECTIVE") ? 1 : 0;
                            countIrony+=commMC.getIrony().equalsIgnoreCase("IRONY") ? 1 : 0;
                            countScore+=getIntFromMCScore(commMC.getScore());
                            countSentences+=commMC.getSentencesCount();
                            commsMC++;
                        }
                        if(commsMC>0) {
                            meanConfidence = countConfidence / commsMC;
                            meanAgreement = (countAgreement / commsMC)*100;
                            meanIrony = (countIrony / commsMC)*100;
                            meanSubjectivity = (countSubjectivity / commsMC)*100;
                            meanSentences=countSentences/commsMC;
                            meanScore = countScore / commsMC;
                        }
                    }

                    query = session.createQuery("from CommentVaderEntity cve where cve.comment.system=false and cve.comment.bug.id=:id");
                    query.setParameter("id", bug.getId());
                    List<CommentVaderEntity> commentAnalysesVdr = (List<CommentVaderEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

                    if (commentAnalysesVdr.size() > 0) {
                        for (CommentVaderEntity commVDR:commentAnalysesVdr) {
                            if(commVDR==null){
                                continue;
                            }
                            countCompound+=commVDR.getCompound();
                            countNegative+=commVDR.getNegative();
                            countNeutral+=commVDR.getNeutral();
                            countPositive+=commVDR.getPositive();
                            commsVDR++;
                        }
                        if(commsVDR>0){
                            meanCompound=countCompound/commsVDR;
                            meanNegative=countNegative/commsVDR;
                            meanNeutral=countNeutral/commsVDR;
                            meanPositive=countPositive/commsVDR;
                        }
                    }


                    pw.append(bug.getId().toString());
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanCompound)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanNegative)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanNeutral)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanPositive)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanConfidence)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanScore)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanIrony)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanAgreement)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanSubjectivity)));
                    pw.append(",");
                    pw.append(String.valueOf(df3.format(meanSentences)));
                    pw.append(",");
                    pw.newLine();


                } catch (Exception ex) {
                    System.out.println("Error during writing to output: " + ex.toString());
                }
            }
            pw.flush();
            pw.close();
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public void exportCommentsOnly(){
        System.out.println("Exporting comments only by bugs");
        DecimalFormat df3 = new DecimalFormat("#.###");
        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from BugEntity be where be.component.id=746");
        List<BugEntity> bugs=(List<BugEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        for (BugEntity bug : bugs) {
            try {
                File csvFile = new File("OutputComments/"+bug.getId()+".csv");
                if (!csvFile.exists()) {
                    csvFile.getParentFile().mkdirs();
                    csvFile.createNewFile();
                }
                BufferedWriter pw = new BufferedWriter(new FileWriter(csvFile, true));
                query = session.createQuery("from CommentEntity ce where ce.system=false and ce.bug.id=:id");
                query.setParameter("id", bug.getId());
                List<CommentEntity> comments = (List<CommentEntity>) query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

                for (CommentEntity comment:comments) {
                    pw.append(comment.getId().toString());
                    pw.append(",");
                    pw.append(comment.getText());
                    pw.append(",");
                    pw.append(comment.getCreator());
                    pw.newLine();
                }

                pw.flush();
                pw.close();
            } catch (Exception ex) {
                System.out.println("Error during writing to output: " + ex.toString());
            }
        }

    }

    private double getIntFromMCScore(String input){
        if ("N+".equalsIgnoreCase(input)) {
            return -1;
        } else if ("N".equalsIgnoreCase(input)) {
            return -0.5;
        }else if ("P".equalsIgnoreCase(input)) {
            return 0.5;
        }else if ("P+".equalsIgnoreCase(input)) {
            return 1;
        }else{
            return 0;
        }
    }
}
