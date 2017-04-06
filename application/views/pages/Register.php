<?php
// define variables and set to empty values
$nameErr = $emailErr = $phoneErr = $pwErr = $cpwErr = $termsErr = "";
$name = $email = $phone = $pw = $cpw = $terms = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Name Required";
  } else {
    $name = test_input($_POST["name"]);
  }
  
  if (empty($_POST["email"])) {
    $emailErr = "SFSU Email Required";
  } else {
    $email = test_input($_POST["email"]);
  }
  
  if (empty($_POST["phone"])) {
    $phoneErr = "";
  } else {
    $phone = test_input($_POST["phone"]);
  }
  
  if (empty($_POST["pw"])) {
    $pwErr = "Password Required";
  } else {
    $pw = test_input($_POST["pw"]);
  }
  
  if (empty($_POST["cpw"])) {
    $cpwErr = "Matching Password Required";
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
<div class='container'>
    <div class="row">
        <div class="text-center">
            <?php
                echo "<h2>Register</h2>";
                echo "<p><span class=\"error\" style=\"color: red\">* REQUIRED FIELD</span></p>";
            ?>

            <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
                <?php 
                    $path = site_url();
                    echo "<label>PERSONAL INFORMATION</label><br>";
                    echo "NAME";
                    echo "<span class=\"error\" style=\"color: red\"> * $nameErr</span>";
                    echo "<br><input type=\"text\" name=\"name\" placeholder=\"John Smith\"><br><br>";
    
                    echo "EMAIL";
                    echo "<span class=\"error\" style=\"color: red\"> * $emailErr</span>";
                    echo "<br><input type=\"text\" name=\"name\" placeholder=\"jsmith@mail.sfsu.edu\"><br><br>";
        
                    echo "PHONE NUMBER <br><input type=\"text\" name=\"phone\" placeholder=\"(555) 555-5555\"><br><br>";
        
                    echo "<label>LOGIN INFORMATION</label><br>";
                    echo "PASSWORD <span class=\"error\" style=\"color: red\"> * $pwErr</span>";
                    echo "<br><input type=\"password\" name=\"pw\"><br><br>";
            
                    echo "CONFIRM PASSWORD <span class=\"error\" style=\"color: red\"> * $cpwErr</span>";
                    echo "<br><input type=\"password\" name=\"cpw\"><br><br>";
        
                    echo "<input type=\"checkbox\" name=\"terms\" autocomplete=\"off\">";
                    echo " I agree to the <a href =\"#\">Terms & Conditions</a>";
                    echo "<span class=\"error\" style=\"color: red\"> * $termsErr</span><br><br>";
                    echo "<input type=\"submit\">";
                ?>
 
            </form>
            
            <?php 
                $path = site_url("/Login");
                echo "<a href='$path'><< Back to login</a>";
            ?>
    
        </div>
    </div>
</div>