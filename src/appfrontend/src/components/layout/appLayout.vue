<template>
  <div>
    <!-- Page Wrapper -->
    <div id="wrapper">
      <mySideBar />

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
          <topBar />

          <!-- Begin Page Content -->
          <div class="container-fluid">
            <slot />
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
        <myfooter></myfooter>
      </div>
      <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
  </div>
</template>

<script>
import myfooter from "../layout/footer";
import mySideBar from "../layout/mySideBar";
import topBar from "../layout/TopBar";
import { mapGetters, mapActions } from "vuex";

export default {
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
  created() {
    this.user = this.getLoggedInUser;

    this.tripcount = this.user.vehicle.trips.length;
    console.log(this.user);
  },
  name: "dashboard",
  components: {
    myfooter,
    mySideBar,
    topBar,
  },
};
</script>