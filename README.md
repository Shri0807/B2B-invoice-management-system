# B2B-invoice-management-system
The Objective of this project is to help businesses to keep track of payment dates in an organized and efficient manner. The project integrates all the invoice details in a single web application making it efficient to view the details of pending invoices.
There are 3 aspects to this project namely: Machine Learning, Front-end/UI development, Back-end development.
The Stack used for all the aspects are:
* ML: Python and related frameworks such as numpy, pandas, sklearn etc.
* Front end: HTML, CSS, Javascript
* Back end: Java, JDBC, Java Servlets, Mysql

## Machine Learning
The Objective of Machine Learning part is to predict the date on which the customer will clear his invoice dues. The dataset includes details of previous transactions done by the customer. 
We use Regression Models to predict the clear date and finally store the new dataset with predicted clear dates in a seperate cvs file.

##  Front-end/UI
The UI has various functionalities integrated in it namely: add, edit, delete, select all.
All the records are fetched from the database and displayed in a tabular format. The rows will be highlighted when checkbox is checked.
![alt text](https://github.com/Shri0807/B2B-invoice-management-system/blob/main/UI.png)

### Add Modal
![alt text](https://github.com/Shri0807/B2B-invoice-management-system/blob/main/UI%20add.png)

### Edit Modal
The Edit button will be enabled only when 1 row from the table is selected.
![alt text](https://github.com/Shri0807/B2B-invoice-management-system/blob/main/UI%20edit.png)

### Delete Modal
The Delete Modal will be enabled when 1 or more than 1 row of the table is selected.
![alt text](https://github.com/Shri0807/B2B-invoice-management-system/blob/main/UI%20delete.png)

## Back-end
The backend of this project uses Java, JDBC and servlets to add, edit and delete data from the database. Mysql is used to execute the queries. The entire project runs on Apache Tomcat v8.5.
