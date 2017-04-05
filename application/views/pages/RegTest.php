<?php
// define variables and set to empty values
$nameErr = $emailErr = $phoneErr = $pwErr = $cpwErr = $termsErr = "";
$name = $email = $phone = $pw = $cpw = $terms = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Required";
  } else {
    $name = test_input($_POST["name"]);
  }
  
  if (empty($_POST["email"])) {
    $emailErr = "Required";
  } else {
    $email = test_input($_POST["email"]);
  }
  
  if (empty($_POST["phone"])) {
    $phoneErr = "";
  } else {
    $phone = test_input($_POST["phone"]);
  }
  
  if (empty($_POST["pw"])) {
    $pwErr = "Required";
  } else {
    $pw = test_input($_POST["pw"]);
  }
  
  if (empty($_POST["cpw"])) {
    $cpwErr = "Required";
  } else {
    $cpw = test_input($_POST["cpw"]);
  }
  
  if (empty($_POST["terms"])) {
    $termsErr = "Must accept Terms & Conditions";
  } else {
    $terms = test_input($_POST["terms"]);
  }
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>

<div class="text-center">
<h2>Register</h2>
<p><span class="error" style="color: red">* REQUIRED FIELD</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    
    <span style="font-weight: bold">PERSONAL INFORMATION</span><br>
    NAME <span class="error" style="color: red">* <?php echo $nameErr;?></span>
    <br><input type="text" name="name" placeholder="John Smith">
    <br><br>
    
    EMAIL <span class="error" style="color: red">* <?php echo $emailErr;?></span>
    <br><input type="text" name="email" placeholder="jsmith@mail.sfsu.edu">
    <br><br>
    PHONE NUMBER <br><input type="text" name="phone" placeholder="(555) 555-5555"><br><br>
    
    <span style="font-weight: bold">LOGIN INFORMATION</span><br>
    PASSWORD <span class="error" style="color: red">* <?php echo $pwErr;?></span>
    <br><input type="password" name="pw" id = "pw"><br><br>
    CONFIRM PASSWORD <span class="error" style="color: red">* <?php echo $cpwErr;?></span>
    <br><input type="password" name="cpw" id = "cpw"><br><br>
    
    <input type="checkbox" name="terms" autocomplete="off">
    I agree to the <a href ="#">Terms & Conditions</a>
    <span class="error" style="color: red">* <?php echo $termsErr;?></span><br><br>
    
    
    <input type="submit">
    
</form>
    <br><p><a href="#"><< Back to login</a></p>
</div>