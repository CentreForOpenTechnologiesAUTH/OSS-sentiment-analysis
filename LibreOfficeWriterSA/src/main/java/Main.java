import com.Models.Configuration;
import com.SentimentAnalysis.MeaningCloudListener;
import com.Utilities.ConfigurationUtility;
import com.Utilities.ExportUtility;
import com.Utilities.PopulationUtility;
import com.Utilities.SentimentAnalysisUtility;

public class  Main{

    public static void main(String args[]){
        System.out.println("Starting the app...");
        ConfigurationUtility configurationUtility=new ConfigurationUtility();
        Configuration configuration= configurationUtility.loadConfiguration();

        if(configuration.isLoaded()) {
            PopulationUtility populationUtility = new PopulationUtility();
            if(configuration.isFetchProducts())
                populationUtility.getProduct();
            if(configuration.isAutoActivate())
                populationUtility.autoActivateComponentsVersions();
            if(configuration.isFetchBugs())
                populationUtility.getBugs();
            if(configuration.isFetchComments())
                populationUtility.getComments();

            SentimentAnalysisUtility sentimentAnalysisUtility=new SentimentAnalysisUtility();
            if(configuration.isAnalyzeWithVader())
                sentimentAnalysisUtility.analyzeCommentsVader();
            if(configuration.isAnalyzeWithMC())
                sentimentAnalysisUtility.analyzeCommentsMC();

            ExportUtility exportUtility=new ExportUtility();
            if(configuration.isExportFromVader())
                exportUtility.exportDataVader();
            if(configuration.isExportFromMC())
                exportUtility.exportDataMC();
            if(configuration.isExportByBugs())
                exportUtility.exportDataByBug();
            if(configuration.isExportOnlyComments())
                exportUtility.exportCommentsOnly();
        }else{
            System.out.println("Configuration could not be loaded ,aborting execution...");
        }





        //updating
//        ProductEntity product=(ProductEntity)session.get(ProductEntity.class,5);
//        product.setProductName("ttest prod");
//        product.getVersions().add(ver1);
//        session.getTransaction().commit();
//        HibernateUtility.shutdown();
        System.out.println("Done ... !");

        //api tests
//        try {
//            ProductListener.test();
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
    }

}
