# OSS-sentiment-analysis
A tool for applying sentiment analysis on open source software bugs discussions. 

The tool utilizes Bugzilla for fetching information regarding bugs and the discussions made by the community around them.
By default, the tool uses the LibreOffice project, the components Writer, Calc and Draw and major versions from 3.3 to 6.1.

For applying sentiment analysis to texts, a lexicon based tool named VADER (Valence Aware Dictionary and sEntiment Reasoner) has been used.
For comparison, a machine-learning based service named Meaning Cloud has been used as a more automated approach.

Refer to the config.txt file, to find the options available for customization of the tool.
