<div class="container-fluid container-login-page">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
            <div class ="panel panel-default">
                <div class="panel panel-heading">
                    <h2 class="text-center">Login</h2> 
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
                                <div class="col-md-3" style="text-align: right">
                                    <label for="email">Email: </label> 
                                </div>
                                <div class="col-md-6">
                                    <input type="email" id="email" name="email" class="form-control">
                                </div>
                                <div class="col-md-3">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-3" style="text-align: right">
                                    <label for="password">Password: </label> 
                                </div>
                                <div class="col-md-6">
                                    <input type="password" id="password" name="password" class="form-control">
                                </div>
                                <div class="col-md-3">
                                </div>
                            </div>
                        </div>
                        <div class="form-group form-inline text-center">
                            <button type="submit" name="submit" value="submit" class="btn btn-success" >Login</button>
                        </div>
                    </form>
                </div>
                <div class="panel-footer text-center">
                    <a href="<?= site_url('Register'); ?>" class="btn btn-default" role="button">Register</a>
                    <a href="<?= site_url('forgotPwd'); ?>" class="btn btn-default" role="button">Forgot password?</a>
                </div>

            </div>
        </div>


</div>
