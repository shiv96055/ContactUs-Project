<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
		<style>
			.container{
				width: 30%;
				border: 1px solid black;	
				margin: auto; 
				padding: 20px;
				font-size: 20px;
				
			}
			
			#contact table tr td input{
			  font-size: 20px;  
			}
		</style>
</head>
<body>
 	<div class="container">
 	  <h1>Contact Us</h1>
 	  <form id = "contact" action = "contactus" method = "post">
 	   		<table>
  				<tr>
  					<td>Full Name</td> 
  				 </tr>
 	   			<tr>
 	   				<td><input type = "text" name = "user_name" placeholder = "Enter here"/></td>
 	   			</tr>
 	   		   <tr>
  					<td>E-mail</td> 
  				 </tr>
 	   			<tr>
 	   				<td><input type = "email" name = "user_email" placeholder = "Enter here"/></td>
 	   			</tr>

 	   			<tr>
  					<td>Message</td> 
  				 </tr>
 	   			<tr>
 	   				<td><input type = "text" name = "user_message" placeholder = "Enter here"/></td>
 	   			</tr>
 	   			<tr>
 	   				<td>
 	   				<button type = "submit">Submit</button>
 	   				</td>
 	   			</tr>
 	   		
 	   		</table>
 	  
 	  </form>
 	
 	</div>

</body>
</html>