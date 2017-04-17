
<div class="container-fluid">
    <div class="text-center">
        <h1>Thank you for signing up with GatorSell!</h1> 
        <p>Please check your email for confirmation code to activate your account.</p>
    </div>
    <form>
        <div class="form-group">
            <label for="code">Enter your confirmation code:</label>
            <input type="code" class="form-control" id="email" placeholder="confimation code">
        </div>
        <div class ="text-right">
            <a href="<?= site_url('Login'); ?>"<button type="cancel" class="btn btn-default">Cancel</button> </a>
            
            <a href="<?= site_url('home'); ?>"<button type="submit" class="btn btn-default">Submit</button> </a>
        </div>
    </form>
</div>

