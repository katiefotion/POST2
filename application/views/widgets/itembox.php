<?php $this->load->helper('html'); ?>
<div class = "panel panel-default">
    <div class = "panel-body">
        <div class = "container-fluid">

            <div class = "row">
                <div class = "col-md-2">
                    <?php
                    $thumbnailUrl = site_url("thumbnail/$item->photo");
                    $uri = "prototype/item/$item->id";
                    echo anchor($uri, "<img src='$thumbnailUrl' class='img-responsive'>");
                    ?>
                </div>
                <div class = "col-md-8">
                    <?php
                    echo "<h3><strong>Item name: </strong>$item->name</h3>";
                    echo "<strong>Description : </strong>";
                    echo "$item->description" . anchor($uri," ...Read More"); ?>
                </div>
                <div class = "col-md-2">
                    <h4>Price: $<?= number_format($item->price, 2);?></h4>
                    <a href="#" class="btn btn-default btn-block btn-wrap" role="button">Buy Now! (goes nowhere in the prototype)</a>
                </div>
            </div>
        </div>
    </div>
</div>
