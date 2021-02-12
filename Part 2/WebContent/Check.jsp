<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Prime Validator </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: lightblue;  
    }   
</style>   
</head>    
<body>    
    <center> <h1> Enter Prime Number </h1> </center>   
    <form action="PrimeMain" >  
        <div class="container">   
        
         <label for="gender">Select type</label>
                                    <br>
                                    <input type="radio"  id="gender" name="Method" required="required" value="1" >Method A
                                    <input type="radio"  id="gender" name="Method" required="required" value="2">Method B
        
        </br>
        </br>
            <label>Enter first number : </label>   
            <input type="text" placeholder="Enter first number" name="First" required>  
            <label>Enter Second Number : </label>   
            <input type="text" placeholder="Enter Second number" name="Second" required>  
            <button type="submit">submit</button>   
           
        </div>   
    </form>     
</body>     
</html>  