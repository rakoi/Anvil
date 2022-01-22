<template>
<div id="nav" >
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar" >

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Anvil Dashboard</div>
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
        <a class="nav-link" href="/parcel/new">
          <i class="fa fa-paper-plane"></i>
          <span>Send</span></a>
      </li>
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
            <a class="collapse-item" href="/parcel/all">All parcels</a>


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
            <a class="collapse-item" href="/user/trips">My Trips</a>
            <a class="collapse-item" href="/trip/new">New Trip</a>
            <a class="collapse-item" href="/trip/all">All Trips</a>
           
          </div>
        </div>
      </li>


      <!-- Divider -->
      <hr class="sidebar-divider">


       <li class="nav-item">
        <a class="nav-link" href="/invoice">
          <i class="fas fa-fw fa-flag"></i>
          <span>Invoices</span></a>
      </li>


    
     

     
      <!-- Nav Item - Charts -->
            <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#accountsdiv"
          aria-expanded="true" aria-controls="accountsdiv">
          <i class="fa fa-money"></i>
          <span>Accounts</span>
        </a>
        <div id="accountsdiv" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Accounts :</h6>
            <a class="collapse-item" href="/user/trips">Trial Balance</a>
            <a class="collapse-item" href="/trip/new">Balance Sheet</a>
            <a class="collapse-item" href="/trip/all">Debit & Aging Report</a>
          
           
          </div>
        </div>
      </li>

       <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-flag"></i>
          <span>Reports</span></a>
      </li>




       <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseParameters"
          aria-expanded="true" aria-controls="collapseParameters">
          <i class="fa fa-cog"></i>
          <span>Parameters</span>
        </a>
        <div id="collapseParameters" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">System Parameters:</h6>
            <a class="collapse-item" href="/user/trips">Users</a>
            <a class="collapse-item" href="/trip/new">Vehicles</a>
            <a class="collapse-item" href="/trip/all">Stations</a>
             <a class="collapse-item" href="/trip/all">Roles</a>
             <a class="collapse-item" href="/trip/all">Clients</a>
              <a class="collapse-item" href="/trip/all">Access Logs</a>
           
          </div>
        </div>
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

<style >
  #accordionSidebar{
    height:100%;
  }
</style>