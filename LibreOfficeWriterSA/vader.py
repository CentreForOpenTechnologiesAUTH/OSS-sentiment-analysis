from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer
import sys
analyser=SentimentIntensityAnalyzer()
print(analyser.polarity_scores(str(sys.argv[1])))
