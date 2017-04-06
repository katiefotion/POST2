
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <div class =" text-center">
                <?php
                    echo "<h2>ALREADY REGISTERED?</h2>";
                ?>
                <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
                    <label>EMAIL</label><br><input type="text" name="email" placeholder="jsmith@mail.sfsu.edu" required><br><br>
                    <label>PASSWORD</label> <br><input type="text" name="password" required><br><br>
                    <input type="submit">
                </form>
                <a href="#" class="btn" role="button">Forgot password?</a>
            </div>
        </div>
    
        <div class="col-sm-6">
            <div class =" text-center">
                <?php 
                    echo "<h2>DONT HAVE AN ACCOUNT?</h2>";
                    echo "<p>Registration only takes a few moments and 
                         you'll receive the following benefits</p>";
                ?>   
            </div>
                <div class=" col-sm-3"></div>
                <div class="col-sm-9">
                    <?php
                        
                        echo "<li>Post items to sell to SFSU students</li>";
                        echo "<li>Access <a href=\"#\">Safe Meeting</a> locations</li>";
                        echo "<li>All your details saved for fast posting</li>";
                        echo "<li>And more!</li><br>";
                    ?>
                </div>
                <?php
                    $path = site_url("/Register");
                    echo "<p class=\"text-center\"><a href='$path' "
                            . "style=\"font-size: large\" class=\"btn btn-default\""
                            . "  role=\"button\">Register Now</a></p>";
                ?>   
            
        </div>
    </div>
</div>