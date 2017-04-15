<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <div class =" text-center">
                <h2>ALREADY REGISTERED?</h2>
                <form method="post" action="<?php site_url('login');?>">
                    <div class="form-group">
                        <label for="email">EMAIL</label>
                        <div>
                            <input type="email" id="email" name="email" placeholder="jsmith@sfsu.edu" class="input-xlarge">
                            <p></p>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="password">PASSWORD</label>
                        <div>
                            <input type="password" id="password" name="password"class="input-xlarge">
                            <p></p>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div>
                            <button type="submit" name="submit" value="submit" class="btn btn-default"><strong>Login</strong></button>
                        </div>
                    </div>
                </form>
                <a href="/forgotPwd" class="btn" role="button">Forgot password?</a>
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
                <li>Access Safe Meeting locations</li>
                <li>All your details saved for fast posting</li>
                <li>And more!</li><br>                
            </div>
             
            <p class="text-center"><a href="/register" style="font-size: large" 
               class="btn btn-default" role="button">Register Now</a></p>     
        
        </div>
    </div>
    
</div>
