# doc_classifier_knn

Pure Java Implementation of K-Nearest Neighbor Text Categorization

BBC Dataset is used( filenames are refactored to [categoryname]-[number] ). Dataset is under "data" folder.
http://mlg.ucd.ie/datasets/bbc.html

Run:


java -jar doc_classifier_knn.jar -Dir=data -categories=business,entertainment,politics,sport,tech -trainingSize=150 -k=3


Written for experimental purpose. It could be optimized and expanded.
