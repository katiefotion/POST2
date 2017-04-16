<div class="container-fluid container-login-page">
    <div class="row">
        <div class="col-sm-6">
            <div class ="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>Already Registered?</h2>                   
                </div>
                <div class="panel-body">
                    <?php if(isset($invalid)){ ?>
                    <div class="alert alert-danger text-center">
                        <strong>Invalid e-mail or password</strong>
                    </div>
                    <?php }?>
                    <form method="post" action="<?= site_url('login'); ?>">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2">
                                    <label for="email">e-mail:</label> 
                                </div>
                                <div class="col-md-6">
                                    <input type="email" id="email" name="email" placeholder="email" class="form-control">
                                </div>
                                <div class="col-md-4">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-2">
                                    <label for="email">Password:</label> 
                                </div>
                                <div class="col-md-6">
                                    <input type="password" id="password" name="password" placeholder="password" class="form-control">
                                </div>
                                <div class="col-md-4">
                                </div>
                            </div>
                        </div>
                        <div class="form-group form-inline pull-right">
                            <button type="submit" name="submit" value="submit" class="btn btn-success">Login</button>
                            <button type="cancel" class="btn btn-danger" onclick="window.history.back();">Cancel</button>
                        </div>
                    </form>
                </div>
                <div class="panel-footer text-center">
                    <a href="<?= site_url('forgotPwd'); ?>" class="btn btn-default" role="button">Forgot password?</a>
                </div>

            </div>
        </div>


        <div class="col-sm-6">
            <div class =" text-center">
                <h2>Don't Have an Account?</h2>
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

            <p class="text-center"><a href="<?= site_url('Register'); ?>" style="font-size: large" 
                                      class="btn btn-default" role="button">Register Now</a></p>     

        </div>
    </div>

</div>
