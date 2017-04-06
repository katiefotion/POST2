
 <head>
    <style>
      #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>

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
                        <option>Books</option>
                        <option>Games</option>
                        <option>Furniture</option>
                        <option>Electronics</option>
                        <option>Other</option>
                    </select>

                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" rows="5" id="description"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="photo">Photo:</label>
                        <input type="file" class="form-control-file" id="photo" aria-describedby="fileHelp">
                        <small id="fileHelp" class="form-text text-muted">File size must be under 4MB.</small>
                    </div>
                </div>
                <div class="form-group">
                    <label for="other">Other:</label>
                    <input type="other" class="form-control" id="other">
                </div>

            </form>

        </div>

        <div class = "col-md-6">

            <h2>Safe Meeting: </h2>
            <div class="form-group">
                <label for="location">Location:</label>
                <select class="form-control" id="category", aria-describedby="fileHelp">
                    <small id="fileHelp" class="form-text text-muted">Choose at least 2 options that are convient for you:</small>
                    <option>Ceasar Chavez</option>
                    <option>Cafe Russo</option>
                    <option>Library</option>
                    <option>Quad</option>
                </select>
                </br>
    <div id="map"></div>
    <script>
        
      function initMap() {
        var uluru = {lat: 37.721897, lng: -122.476111};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
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
                            <div class = "col-md-12">

                                <h2><strong>TODO: Add CANCEL & ADD buttons</h2>

                                <a href="#" class="btn btn-default btn-block btn-default" role="button">Cancel</a>
                                <a href="#" class="btn btn-default btn-block btn-wrap" role="button">Add</a>

                            </div>
                        </div>
</div>

