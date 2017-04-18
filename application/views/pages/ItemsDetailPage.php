<div class = "container-fluid">
    <div class = "row">
        <div class = "col-md-3 min-lr-pad">
            <?php
            $path = site_url("dbimg/$item->photo");
            echo "<img src='$path' class='img-responsive'>";
            ?>
        </div>
        <div class = "col-md-7">
            <?php
            echo "<h2><strong>Title: </strong>$item->name</h2>";
            echo "<h2><strong>Price: $</strong>$item->price</h2>";
            echo "<h2><strong>Catageory: </strong>$item->category_id</h2>";
            echo "<h3><strong>Description </strong></h3><br>";
            echo "<p>$item->description</p>";
            ?>
        </div>
        <div class = "col-md-2">
            <h3>Price: $<?= number_format($item->price, 2); ?></h3>
            <a href="#" class="btn btn-default btn-block btn-wrap" role="button">Buy Now! (goes nowhere in the prototype)</a>
        </div>
    </div>
</div>
