<template>
<div id="nav">
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Anvil Dashboard <sup>Conductor</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="/">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Home</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Action
      </div>
      <!-- Nav Item - New -->
      <li class="nav-item">
        <a class="nav-link" href="Send.html">
          <i class="fa fa-paper-plane"></i>
          <span>Send</span></a>
      </li>


      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
          aria-controls="collapseTwo">
          <i class="fa fa-qrcode"></i>
          <span>Load Parcels</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">

            <h6 class="collapse-header">Load</h6>
            <a class="collapse-item" href="send.html">New parcel</a>
            <a class="collapse-item" href="scan.html">Scan parcel</a>

          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
          aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fa fa-road"></i>
          <span>Trip</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Trips:</h6>
            <button class="btn btn-link collapse-item" data-toggle="modal" data-target="#exampleModalCenter">Start New
              Trip</button>
            <a class="collapse-item" href="trips.html">All Trips</a>
            <button class="btn btn-link collapse-item" data-toggle="modal" data-target="#fuelModalCenter">Add
              Fuel</button>
            <button class="btn btn-link collapse-item" data-toggle="modal" data-target="#expensesModalCenter">Add new
              Expense</button>
            <button class="btn btn-link collapse-item" data-toggle="modal" data-target="#checkinModalCenter">Check
              In</button>
            <button class="btn btn-link collapse-item" data-toggle="modal" data-target="#endModalCenter">End
              Trip</button>
          </div>
        </div>
      </li>

     

      

     

      <div class="modal fade" id="checkinModalCenter" tabindex="-1" role="dialog"
        aria-labelledby="checkinModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="checkinModalLongTitle">Check In Office/Drop-off</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form>

                <div class="form-group row">
                  <label for="PaidBy" class="col-sm-2 col-form-label">Office</label>
                  <div class="col-sm-10">
                    <select id="PaidBY" name="paidby" class="form-control">
                      <option value="1">Nairobi- Ngara</option>
                      <option value="2">Nairobi -Kamukunji</option>
                      <option value="3">Nairobi - Cross Roads</option>
                      <option value="4">Nairobi- Eastliegh</option>
                      <option value="5">Mwea</option>
                      <option value="5">Embu</option>
                      <option value="5">Runyenjes</option>
                      <option value="5">Chuka</option>
                      <option value="5">Nkubu</option>
                      <option value="5">Meru</option>
                      <option value="5">Kianjai</option>
                      <option value="5">Maua</option>
                      <option value="5">Isiolo</option>
                      <option value="5">Nanyuki</option>
                      <option value="5">Nyeri</option>
                      <option value="5">Kerugoya</option>

                    </select>
                  </div>
                </div>
                <div class="form-group row">
                  <button type="submit" class="btn btn-primary" data-dismiss="modal">Submit</button>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

            </div>
          </div>
        </div>
      </div>

      <!--End trip Modal -->

      <div class="modal fade" id="endModalCenter" tabindex="-1" role="dialog" aria-labelledby="endModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="endModalLongTitle">Select your ending Point</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form>

                <div class="form-group row">
                  <label for="PaidBy" class="col-sm-2 col-form-label"> Office:</label>
                  <div class="col-sm-10">
                    <select id="PaidBY" name="paidby" class="form-control">
                      <option value="1">Nairobi- Ngara</option>
                      <option value="2">Nairobi -Kamukunji</option>
                      <option value="3">Nairobi - Cross Roads</option>
                      <option value="4">Nairobi- Eastliegh</option>
                      <option value="5">Mwea</option>
                      <option value="5">Embu</option>
                      <option value="5">Runyenjes</option>
                      <option value="5">Chuka</option>
                      <option value="5">Nkubu</option>
                      <option value="5">Meru</option>
                      <option value="5">Kianjai</option>
                      <option value="5">Maua</option>
                      <option value="5">Isiolo</option>
                      <option value="5">Nanyuki</option>
                      <option value="5">Nyeri</option>
                      <option value="5">Kerugoya</option>

                    </select>
                  </div>
                </div>
                <div class="form-group row">
                  <button type="submit" class="btn btn-primary" data-dismiss="modal">Submit</button>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

            </div>
          </div>
        </div>
      </div>
      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseParcels"
          aria-expanded="true" aria-controls="collapseTwo">
          <i class="fa fa-truck"></i>
          <span>Parcels</span>
        </a>
        <div id="collapseParcels" class="collapse" aria-labelledby="headingParcels" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">

            <h6 class="collapse-header">Parcels</h6>
            <a class="collapse-item" href="/parcel/new">New</a>
            <a class="collapse-item" href="parcels.html">All parcels</a>


          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        KCL 000H
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
          aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Maintenance</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Login Screens:</h6>
            <a class="collapse-item" href="login.html">Login</a>
            <a class="collapse-item" href="register.html">Register</a>
            <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">Other Pages:</h6>
            <a class="collapse-item" href="404.html">404 Page</a>
            <a class="collapse-item" href="blank.html">Blank Page</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Fuel</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>Expenses</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

</div>
</template>

<script>
</script>