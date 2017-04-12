<div class="container-fluid">   
    <div class="col-md-2"></div>
    <div class="col-md-8 text-center">
        
       <h2>Register</h2>
       <form action='' method="POST">
            <div class="form-group">
                <label for="name">NAME</label><br>
                <input type="text" id="name" name="name" placeholder="John Smith" class="input-xlarge">
                <p></p>
            </div>
 
            <div class="form-group">
                <label for="email">EMAIL</label><br>
                <input type="email" id="email" name="email" placeholder="jsmith@sfsu.edu" class="input-xlarge">
                <p class="help-block">Please provide your SFSU email</p>
            </div>
 
            <div class="form-group">
                <label for="phone">PHONE NUMBER</label><br>
                <input type="text" id="phone" name="phone" placeholder="(555) 555-5555" class="input-xlarge">
                <p></p>
            </div>
            
            <div class="form-group">      
                <label for="password">PASSWORD</label><br>
                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                <p class="help-block">At least 7 characters</p>
            </div>
 
            <div class="control-group">
            <!-- needs to check that they're the same password -->
                <label for="confirm_password">CONFIRM PASSWORD</label><br>
                <input type="password" id="password_confirm" name="confirm_password" placeholder="" class="input-xlarge">
                <p class="help-block">Please confirm password</p>
            </div>
    
           <div class="form-group">
               <p><input type="checkbox" name="terms" autocomplete="off">
                   I agree to the <a href="#"> Terms & Conditions</a></p>
           </div>
           
            <div class="form-group">
                <button class="btn btn-danger">Cancel</button>
                <button class="btn btn-success">Register</button>
            </div>
           
        </form> 
    </div>
    <div class="col-md-2"></div>            
        
</div>

