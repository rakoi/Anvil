<template>
  

<div>
 <appLayout>
       <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
        

          <!-- Begin Page Content -->
          <div class="container-fluid">
            <!-- Page Heading -->
            <div
              class="d-sm-flex align-items-center justify-content-between mb-4"
            >
              <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
              <a
                href="#"
                class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                ><i class="fas fa-download fa-sm text-white-50"></i> Generate
                Report</a
              >
            </div>

            <!-- Content Row -->
            <div class="row">
              <!-- Earnings (Monthly) Card Example -->
              <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row no-gutters align-items-center">
                      <div class="col mr-2">
                        <div
                          class="text-xs font-weight-bold text-primary text-uppercase mb-1"
                        >
                          Assigned Vehicle
                        </div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                          <a
                            href="vehilcle-Gh45.html"
                            class="card-link"
                            v-if="this.user.vehicle"
                          >
                            {{ this.user.vehicle.reg_no }}</a
                          >
                          <a class="card-link disabled" v-else> N/A</a>
                        </div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-truck fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <!-- Earnings (Monthly) Card Example -->
              <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-info shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row no-gutters align-items-center">
                      <div class="col mr-2">
                        <div
                          class="text-xs font-weight-bold text-info text-uppercase mb-1"
                        >
                          Trips
                        </div>
                        <div class="row no-gutters align-items-center">
                          <div class="col-auto">
                            <div
                              class="h5 mb-0 mr-3 font-weight-bold text-gray-800"
                            >
                              <a
                                href="parcels.html"
                                class="card-link"
                                style="padding-left:150%"
                                v-if="this.user.vehicle"
                                >{{ tripcount }}</a
                              >
                              <a class="card-link disabled" v-else> Nsss/A</a>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-paper-plane fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <!-- Earnings (Monthly) Card Example -->
            </div>
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
       
      </div>
      <!-- End of Content Wrapper -->
 </appLayout>
</div>


</template>
<script>

import appLayout from '../layout/appLayout'
import { mapGetters, mapActions } from "vuex";
export default{
    data() {
    return {
      user: {},
      tripcount: 0,
    };
  },
  computed: mapGetters(["getLoggedInUser"]),
  methods: {
    ...mapActions(["getUser"]),
  },
  components:{
   appLayout
  },
    created() {
    this.user = this.getLoggedInUser;
    

    this.tripcount = this.user.vehicle.trips.length;
   
  }
}

</script>

