<form class="navbar-form navbar-left" method="get" action="<?= site_url('items');?>">
    <div class="form-group">
        <select class="form-control" name="category">
            <option selected value="0">All</option>
            <?php
            foreach ($categories as $category) {
                $x = $selected == $category['id'] ? "selected" : "";
                echo "<option $x value='{$category['id']}'>{$category['category']}</option>\n";
            }
            ?>
        </select>
        <input type="text" name="query" class="form-control" placeholder="Search">
    </div>
    <button type="submit" class="btn btn-default">Search</button>
</form>