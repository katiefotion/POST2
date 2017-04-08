<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <div class =" text-center">
                <h2>ALREADY REGISTERED?</h2>
                <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
                    <div class="control-group">
                        <label class="control-label"  for="email">EMAIL</label>
                        <div class="controls">
                            <input type="email" id="email" name="email" placeholder="jsmith@sfsu.edu" class="input-xlarge">
                            <p></p>
                        </div>
                    </div>
                    
                    <div class="control-group">
                        <label class="control-label"  for="password">PASSWORD</label>
                        <div class="controls">
                            <input type="password" id="password" name="password"class="input-xlarge">
                            <p></p>
                        </div>
                    </div>
                    
                    <div class="control-group">
                        <div class="controls">
                            <button class="btn btn-default"><strong>Login</strong></button>
                        </div>
                    </div>
                </form>
                <a href="#" class="btn" role="button">Forgot password?</a>
            </div>
        </div>
    
        <div class="col-sm-6">
            <div class =" text-center">
                <h2>DONT HAVE AN ACCOUNT?</h2>
                <p>Registration only takes a few moments and 
                   you'll receive the following benefits</p>
            </div>
                        
            <div class=" col-sm-3"></div>
            <div class="col-sm-9">
                <li>Post items to sell to SFSU students</li>
                <li>Access <a href="#">Safe Meeting</a> locations</li>
                <li>All your details saved for fast posting</li>
                <li>And more!</li><br>                
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
