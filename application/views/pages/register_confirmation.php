
<div class="container-fluid">
    <div class="text-center">
        <h1>Thank you for signing up with GatorSell!</h1> 
        <p>Please check your email for a confirmation code to activate your account.</p>
    </div>
    <div class="col-md-3"></div>
    <div class="col-md-6 text-center"><br>
        
            <form>
                <div class="form-group">
                    <label for="code">Enter your confirmation code:</label>
                    <input type="code" class="form-control" id="email" placeholder="confimation code">
                </div>
                <div class ="text-right">
                    <a href="<?= site_url('Login'); ?>"<button type="cancel" class="btn btn-danger">Cancel</button> </a>

                    <a href="<?= site_url('home'); ?>"<button type="submit" class="btn btn-success">Submit</button> </a>
                </div>
            </form>
        
    </div>
    <div class="col-md-3"></div>   
</div>

