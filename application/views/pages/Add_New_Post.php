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
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>

                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" rows="5" id="description"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="photo">Photo:</label>
                        <input type="photo" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
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
            
            <h2><strong>Safe Meeting: </h2>
                     <div class="form-group">
                    <label for="location">Location:</label>
                    <select class="form-control" id="category", aria-describedby="fileHelp">
                          <small id="fileHelp" class="form-text text-muted">Choose at least 2 options that are convient for you:</small>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>
      
        </div>
 </div>
      <div class = "row">
        <div class = "col-md-12">
               <?php
            echo "<h2><strong>TODO: Add CANCEL & ADD buttons</h2>";
            ?>
            <a href="#" class="btn btn-default btn-block btn-default" role="button">Cancel</a>
            <a href="#" class="btn btn-default btn-block btn-wrap" role="button">Add</a>

    </div>
</div>
