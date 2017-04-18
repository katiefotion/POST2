<?php
$seller = "Morty Smith";
$description = "Harry Potter The Tales of Beedle the Bard";
?>

<div class="container-fluid"> 
    <h1></h1>
    <div class="row">
        <div class="col-md-2"></div>
        <div class ="col-md-8 ">
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h1>Message Seller</h1>
                </div>
                <div class="panel-body">
                    <div class="col-md-1"></div>
                    <div class="col-sm-10">
                        <div class="row">
                            <p>Message the seller about purchasing the item or about questions pertaining to the product</p> 
                        </div>
                        <div class="row ">
                            <form class="form-horizontal" action='<?= site_url('confirmation'); ?>' method="POST">
                                <div class="row">
                                    <label for="to">TO</label>                  
                                    <div class="panel panel-default panel-body">
                                        <?php
                                        echo $seller;
                                        ?>  
                                    </div>
                                </div>

                                <div class="row"> 
                                    <label for="item_description">ITEM</label>
                                    <div class="panel panel-default panel-body">
                                        <?php
                                        echo $description;
                                        ?>
                                    </div>
                                </div>

                                <div class="row">
                                    <label for="message">MESSAGE</label>
                                    <textarea class="form-control" rows="6" id="message"></textarea>
                                    <p></p>
                                    <div class="text-right">
                                        <button class="btn btn-danger" onclick="window.history.back();">Cancel</button>
                                        <button class="btn btn-success" type="submit">Send Message</button>
                                    </div>
                                </div>
                            </form>
                        </div>    
                    </div>
                    <div class="col-md-1"></div>              
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>  
</div>