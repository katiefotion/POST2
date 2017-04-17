<?php
    $seller = "Morty Smith";
    $description = "Harry Potter";
?>
<div class="container-fluid">
    <div class="row">
	<H1 class="text-center">Message Seller</H1>
    </div>
	
    <div class="row">
        <div class="text-center">
            <p>Message the seller about purchasing the item or about questions pertaining to the product</p>    
        </div>
    </div>
    
    <div class="row ">
        <form class="form-horizontal" action='' method="POST">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6 form-group">
                    <label for="to">TO</label>                  
                    <div class="panel panel-default panel-body">
                        <?php
                            echo $seller;
                        ?>
                    </div>
                </div>  
            </div>
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6 form-group">
                    <label for="item_description">ITEM</label>
                    <div class="panel panel-default panel-body">
                        <?php
                            echo $description;
                        ?>
                    </div>
                </div>  
            </div>

            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6 form-group">
                    <label for="message">MESSAGE</label>
                    <textarea class="form-control" rows="5" id="message"></textarea>
                    <p></p>
                    <div class="text-right">
                        <button class="btn btn-danger" onclick="window.history.back();">Cancel</button>
                        <button class="btn btn-success" type="submit"><a href="<?= site_url('Register'); ?>" style="color: white">Send Message</a></button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>