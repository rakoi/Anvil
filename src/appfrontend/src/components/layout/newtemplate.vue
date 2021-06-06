<template>
  <div>
    <!-- Page Wrapper -->
    <div id="wrapper">
      <mySideBar />

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
          <TopBar />

       
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

import TopBar from './TopBar'
import myfooter from './footer'
import mySideBar from './mySideBar'
export default {
    components:{
        TopBar,
        mySideBar,
        myfooter
    }
}
</script>