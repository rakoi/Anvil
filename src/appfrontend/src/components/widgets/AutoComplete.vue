<template>
  <div id="autocomplete">
    <vue-autosuggest
      v-model="number"
      :suggestions="[
        {
          data: phoneNumbers,
        },
      ]"
      :input-props="{
        class: 'form-control',
        id: 'autosuggest__input',
        placeholder: 'Phone Number',
      }"
      @input="searchByNumber"
      @selected="selectHandler"
      @click="clickHandler"
    >
      <template slot-scope="{ suggestion }">
        <span class="my-suggestion-item"
          >{{ suggestion.item.phone }} {{ suggestion.item.first_name }}
          {{ suggestion.item.last_name }}</span
        >
      </template>
    </vue-autosuggest>
  </div>
</template>

<script>
import { HTTP } from "../../common/http-common";

export default {
  data() {
    return {
      number: "+2547",
      phoneNumbers: null,
      client:null,
    };
  },
  methods: {
    clickHandler(item) {
      console.log(item);
    },
    selectHandler(item) {
      let phone = item.item.phone;
      this.client=item.item;
       this.$emit('childToParent', this.client)
      this.number = phone;
    },
    searchByNumber() {
      //let token=localStorage.getItem('anvil_token');

    
      if (this.number.length > 7) {
        HTTP.get(`client/searchByPhone/${this.number}`)
          .then((resp) => {
         
            this.phoneNumbers = resp.data;
          })
          .catch((error) => {
            console.log(error);
          });
      }else{
        this.phoneNumbers=null;
      }
    },
  },
};
</script>

<style  >


.demo {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}

input {
  width: 260px;
  padding: 0.5rem;
}

#autocomplete ul {
  width: 100%;
  color: rgba(30, 39, 46, 1);
  list-style: none;
  margin: 0;
  background-color: #ffff;
  padding: 0.5rem 0 0.5rem 0;
}
li {
  margin: 0 0 0 0;
  border-radius: 5px;
  padding: 0.75rem 0 0.75rem 0.75rem;
  display: flex;
  align-items: center;
}
li:hover {
  cursor: pointer;
}

.autosuggest-container {
  display: flex;
  justify-content: center;
  width: 280px;
}

#autosuggest {
  width: 100%;
  display: block;
}
.autosuggest__results-item--highlighted {
  background-color: rgba(51, 217, 178, 0.2);
}
</style>