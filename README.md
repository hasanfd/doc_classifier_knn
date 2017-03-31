# doc_classifier_knn

Java Implementation of K-Nearest Neighbor Text Categorization

BBC Dataset is used( filenames are refactored to [categoryname]-[number] ). Dataset is under "data" folder.

Run:
java -jar doc_classifier_knn.jar -Dir=data -categories=business,entertainment,politics,sport,tech -trainingSize=150 -k=3
