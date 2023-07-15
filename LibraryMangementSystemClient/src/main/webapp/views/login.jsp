<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <style>
      .form-container {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px 0px #000;
      }
    </style>
<title>Library Managment System</title>
</head>
<body>
<body>
    <div class="container text-center mt-5">
      <h2>LIBRARY MANAGEMENT LOGIN</h2>
    </div>
    <div class="container-fluid mt-5 ">
      <div class="row justify-content-center">
        <div class="col-12  col-md-6">
            <form class="form-container" action="home" method="post">
                <div class="row">
                  <div class="form-group">
                    <div class="row">
                      <div class="col-3">
                        <label class="fs-4" for="colour"><strong>Username</strong></label>
                      </div>
                      <div class="col-6">
                        <input
                          type="text"
                          id="colour"
                          name="username"
                          class="form-control"
                          minlength="5"
                          maxlength="50"
                          required
                        />
                      </div>
                    </div>
                  </div>
                  <div class="form-group mt-3">
                    <div class="row">
                      <div class="col-3">
                        <label class="fs-4" for="colour"><strong>Password</strong> </label>
                      </div>
                      <div class="col-6">
                        <input
                          type="password"
                          id="colour"
                          name="password"
                          class="form-control"
                          minlength="5"
                          maxlength="50"
                          required
                        />
                      </div>
                    </div>
                  </div>
                </div>
        
                <div class="row">
                    <div class="col-3">
                      
                    </div>
                    <div class="col-4 mt-3">
                    <button
                        id="submit"
                        class="btn btn-primary btn-md"
                        type="submit"
                      >
                        Login
                      </button>
                      <button class="btn btn-danger btn-md" type="reset" id="reset">
                        Clear
                      </button>
                    </div>
              </form>
            </div>
      </div>
    </div>
  </body>
</body>
</html>