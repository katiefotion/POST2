<div class="jumbotron">
	<div class="container">
		<div class="row">
				<H1 class="text-center">Login</H1>
		</div>
	</div>
</div>



<div class="row">
    <div class="col-sm-6">
        <div class =" text-center">
            <h2>ALREADY REGISTERED?</h2>
            <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
                EMAIL<br><input type="text" name="email" placeholder="jsmith@mail.sfsu.edu"><br><br>
                PASSWORD <br><input type="text" name="password"><br><br>
                <input type="submit">
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
            
            
            <div class=" col-sm-3">
                
            </div>
            <div class="col-sm-9">
                <li>Post items to sell to SFSU students</li>
                <li>Access <a href="#">Safe Meeting</a> locations</li>
                <li>All your details saved for fast posting</li>
                <li>And more!</li><br>
                
            </div>
                
            <p class = "text-center"><a href="#" style="font-size: large"
                    class="btn btn-default" role="button">Register Now</a>
            </p>    
        
    </div>
</div>
