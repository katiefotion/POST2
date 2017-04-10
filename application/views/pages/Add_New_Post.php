
<?php
    $categories = array(
        array('id' => '', 'category' => 'Furniture'),
        array('id' => '', 'category' => 'Books'),
        array('id' => '', 'category' => 'Video Games'),
        array('id' => '', 'category' => 'Other'),
    );
    
    $locations = array(
        array('location' => "Quad"),
        array('location' => "Ceasar Chavez"),
        array('location' => "Library"),
        array('location' => "Cafe Russo"),
    );
?>
<div class = "container-fluid">

    <div class = "row">
        <div class = "col-md-6">
            <h2>Add New Post:</h2>

            <form>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="name" class="form-control" id="name", placeholder="Title">
                </div>

                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="price" class="form-control" id="price" placeholder="$">
                </div>

                <div class="form-group">
                    <label for="category">Category:</label>
                    <select class="form-control" id="category">

                        <?php
                        foreach ($categories as $cat) {
                            echo "<option>$cat[category]</option>";
                        }
                        ?>

                    </select>

                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" rows="5" id="description" name = "description"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="photo">Photo:</label>
                        <input type="file" class="form-control-file" id="photo"  name = "photo" aria-describedby="fileHelp">
                        <small id="fileHelp" class="form-text ">File size must be under 4MB.</small>
                    </div>
                </div>


            </form>

        </div>

        <div class = "col-md-6">

            <h2>Safe Meeting: </h2>
            <div class="form-group">
                <label for="location">Location:</label>
                <select class="form-control" id="locations" name = "location" aria-describedby="fileHelpLoc">
                    <?php
                    foreach ($locations as $loc) {
                        echo "<option>$loc[location]</option>";
                    }
                    ?>
                    <small id="fileHelpLoc" class="form-text">Choose at least 2 options that are convient for you:</small>

                </select>
                </br>
                <div id="map"></div>
                <script>
        
                  function initMap() {
                    var uluru = {lat: 37.722558, lng: -122.4780799};
                    var map = new google.maps.Map(document.getElementById('map'), {
                      zoom: 16,
                      center: uluru
                    });
                    var marker = new google.maps.Marker({
                      position: uluru,
                      map: map
                    });
                  }
                </script>
                <script async defer
                        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCPPBuI9Ok7SqFArQX8RjzG4DP4jfLZABc&callback=initMap">
                </script>

            </div>
        </div>
    </div>
    <div class = "row">
        <div class = "col-md-5"> </div>
        Still need to add href to Cancel Button
        <div class = "col-md-1"> 
            <a href="./" class="btn btn-danger btn-block" role="button">Cancel</a>
        </div>
        <div class = "col-md-1"> 

            <button type="submit" class="btn btn-success btn-block">Add</button>
 
        </div>
        <div class = "col-md-5"> </div>
    </div>

</div>

