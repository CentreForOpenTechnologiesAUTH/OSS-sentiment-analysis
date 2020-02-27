package com.Utilities;

import com.Hibernate.HibernateUtility;
import com.Models.Entities.CommentEntity;
import com.Models.Entities.CommentMCEntity;
import com.Models.Entities.CommentVaderEntity;
import com.Models.InputObjects.MeaningCloudObject;
import com.Models.InputObjects.SentimentObject;
import com.SentimentAnalysis.MeaningCloudListener;
import com.SentimentAnalysis.VaderListener;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * This utility is responsible for sending all the fetched data for sentiment analysis
 * in the specified API/application and then storing the outcome in the database
 */
public class SentimentAnalysisUtility {
    public void analyzeCommentsVader(){
        VaderListener vaderListener=new VaderListener();
        Session session= HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from CommentEntity");
        List<CommentEntity> comments=(List<CommentEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("Found "+comments.size()+" comments in database ,sending for analysis to Vader");
        session.beginTransaction();
        long startTime = System.currentTimeMillis();
        int count=0;
        int completionCount=0;
        int max=comments.size();
        for (CommentEntity comment:comments) {
            try {
                SentimentObject.Sentiment sentiment = vaderListener.analyzeText(comment.getText());
                if(sentiment==null){
                    continue;
                }
                CommentVaderEntity commentVaderEntity = new CommentVaderEntity(
                        comment.getId(),comment, sentiment.getNegative(), sentiment.getNeutral(), sentiment.getPositive()
                        , sentiment.getCompound());
                session.save(commentVaderEntity);
                if(count%20==0){
                    session.flush();
                    session.clear();
                }
                count++;
                completionCount++;
                if(((float)completionCount/(float)max)*100>10){
                    long tempEndTime=System.currentTimeMillis();
                    System.out.println("Analyzed "+count+" out of "+max+" comments so far (elapsed :"+((tempEndTime-startTime)/1000)+" sec)");
                    completionCount=0;
                }
            }catch (Exception ex){
                System.out.println(ex.toString());
            }
        }
        long endTime=System.currentTimeMillis();
        session.getTransaction().commit();
        System.out.println("Analyzed and saved analysis for "+count+" comments in "+((endTime-startTime)/1000)+" sec");
        HibernateUtility.shutdown();
    }

    public void analyzeCommentsMC(){
        MeaningCloudListener meaningCloudListener=new MeaningCloudListener();
        Session session=HibernateUtility.getSessionFactory().openSession();
        Query query=session.createQuery("from CommentEntity");
        List<CommentEntity> comments=(List<CommentEntity>)query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("Found "+comments.size()+" comments in database ,sending for analysis to Meaning Cloud");
        session.beginTransaction();
        long startTime = System.currentTimeMillis();
        int count=0;
        int completionCount=0;
        int max=comments.size();
        for (CommentEntity comment:comments) {
            try {
                MeaningCloudObject.Sentiments sentiments = meaningCloudListener.analyzeText(comment.getText());
                if(sentiments==null){
                    continue;
                }
                int sentences=sentiments.getSentenceList()!=null?sentiments.getSentenceList().size():0;
                CommentMCEntity commentMCEntity = new CommentMCEntity(
                        comment.getId(),comment,sentiments.getScoreTag(),sentiments.getAgreement(),sentiments.getSubjectivity(),sentiments.getIrony(),Integer.parseInt(sentiments.getConfidence()),sentences);
                session.save(commentMCEntity);
                if(count%20==0){
                    session.flush();
                    session.clear();
                }
                count++;
                completionCount++;
                if(((float)completionCount/(float)max)*100>10){
                    long tempEndTime=System.currentTimeMillis();
                    System.out.println("Analyzed "+count+" out of "+max+" comments so far (elapsed :"+((tempEndTime-startTime)/1000)+" sec)");
                    completionCount=0;
                }
            }catch (Exception ex){
                System.out.println(ex.toString());
            }
        }
        long endTime=System.currentTimeMillis();
        session.getTransaction().commit();
        System.out.println("Analyzed and saved analysis for "+count+" comments in "+((endTime-startTime)/1000)+" sec");
        HibernateUtility.shutdown();
    }
}
