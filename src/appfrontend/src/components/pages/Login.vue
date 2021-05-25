<template>
  <div class="login bg-gradient-primary" style="height: 100vh">
    <div class="container">
      <!-- Outer Row -->
      <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
          <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
              <!-- Nested Row within Card Body -->
              <div class="row">
                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                <div class="col-lg-6">
                  <div class="p-5">
                    <div class="text-center">
                      <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                    </div>
                    <form class="user" id="loginform">
                      <div class="form-group">
                        <input
                          type="text"
                          name="email"
                          class="form-control form-control-user"
                          v-model="username"
                          id="email"
                          aria-describedby="emailHelp"
                          placeholder="Enter Username..."
                        />
                      </div>
                      <div class="form-group">
                        <input
                          type="password"
                          name="password"
                          class="form-control form-control-user"
                          v-model="password"
                          required
                          id="password"
                          placeholder="Password"
                        />
                      </div>
                      <div class="form-group"></div>

                      <div class="alert alert-danger" v-if="fail" id="feedback">
                        {{ feedback }}
                      </div>

                      <input
                        value="Sign In"
                        type="submit"
                        :disabled="loggingIn"
                        @click="loginUser"
                        class="btn btn-primary btn-user btn-block"
                      />

                      <hr />
                    </form>
                    <hr />
                    <div class="text-center">
                      <a class="small" href="">Forgot Password?</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "Login",
  computed: mapGetters(["getLoggedInStatus"]),
  data() {
    return {
      username: "brianrakoi",
      password: "fsociety",
      feedback: "",
      loggingIn:false,
      fail: false,
    };
  },
  methods: {
    ...mapActions(["sendToLoginPage", "logIn"]),
    loginUser(e) {
      e.preventDefault();
      if (
        this.username == null ||
        this.password == null ||
        this.username.length === 0 ||
        this.password.length === 0
      ) {
        this.feedback = "Fill in all fields";
        this.fail = true;
      } else {
        this.fail = false;
        this.feedback = "";
        var credentials = {};
        credentials.username = this.username;
        credentials.password = this.password;

        this.loggingIn=true;
        this.logIn(credentials).then((response) => {
        this.loggingIn=false;
          if (response.data.error) {
            this.fail = true;
            this.feedback = response.data.error;
          } else {
            this.feedback = "";
          }
        });

      }
    },
  },
};
</script>