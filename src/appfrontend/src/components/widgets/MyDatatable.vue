<template>
<div class="ui container">
   
    <div class="row">
        <div class="col col-md-9" >
        <a :href="newUrl" 

        @click=newButtonClicked();
         v-if="showNew" class="btn btn-primary" style="margin-top:24px " >{{newText}}</a>
        </div>
        <div class="col col-md-3">
            <label> Search </label>
            <input class="form form-control" v-model="search" placeholder="SEARCH">
            <br>
        </div>
    </div>

    <div class="row" >
        <div class="col col-md-12">
            <table class="table table-bordered table-hover table-default" >
                <thead>
                    <tr>
                        <th v-for="column in columns" :key="column" scope="col">
                            {{ column.toUpperCase()}}
                        </th>
                        <th v-if="showEdit"  >
                            EDIT
                        </th>
                         <th v-if="showDelete"  >
                            Delete
                        </th>
                         <th v-if="showCustom"  >
                            {{customButtonText}}
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="row in content" :key="row.id">
                        <td v-for="value in values" :key="value" scope="row">
                            {{generateValue(row,value)}}
                   
                        </td>
                        <td v-if="showEdit" >

                             
                            <a class="btn btn-warning"  @click="EditButtonClicked(row)"  ><i class="fa fa-edit" aria-hidden="true"></i> Modify <span class="glyphicon glyphicon-envelope"></span> </a>
                        </td>
                        <td  v-if="showDelete" >
                            <button data-toggle="modal" data-target="#myModal" @click="deleteItem(row['id'])" class="btn btn-danger "> <i class="fa fa-trash" aria-hidden="true"></i> Delete</button>
                        </td>

                         <td v-if="showCustom"  >

                             
                            <a class="btn btn-info"  @click="customButtonClicked(row)"   ><i class="fa fa-tasks"  aria-hidden="true"></i> {{customButtonText}} <span class="glyphicon glyphicon-envelope"></span> </a>
                        </td>
                    <tr>

                    </tr>

                </tbody>
                <div v-if="content.length<1">
                    <i class="alert ">No data available</i>
                </div>
            </table>
        </div>
    </div>

    <div class="row"   >

        <div class=" col-md-7 ">

        </div>

        <div class=" col-md-4 ">
        
            <ul class="pagination">
                <li>
                    <button   class="btn btn-primary" @click="previousClicked()" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </button>
                </li>
                <li v-for="n in pageCount" v-bind:key="n">
                    <button class="btn btn-default" v-bind:class="{ 'btn btn-primary' : currentPage == n}" @click="fetchPageData(n)">{{n}}</button>
                </li>

                <li>
                    <button class="btn btn-primary" @click="nextClicked()" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </button>
                </li>
            </ul>

        </div>
    </div>

    <ConfirmDialog></ConfirmDialog>
</div>
</template>

<script>
import axios from 'axios';
import ConfirmDialog from 'primevue/confirmdialog';


export default {
    components: {
        ConfirmDialog
    },
    computed:{
     
    },
    props: ['columns', 'url', 'values','showDelete','showEdit','deleteUrl','editUrl','showNew','newText','newUrl','customButtonText','customButton','showCustom'],
    data() {
        return {
            showDeleteModal: false,
            showDeleteModalCounter:0,
            content: [],
            search: '',
            currentPage: '',
            pageCount: '',
            PageUrl: '',
       
            deleteItemId: null
        }
    },
    methods: {

        generateValue:function(row,value){
            
            let index= value.split(".");
            if(index.length>1){
                return row[index[0]][index[1]]
            }
            return row[value];
        },

           generateEditUrl:function(itemId){
            return this.editUrl+"/"+itemId;
            
        },
        newButtonClicked:function(){
           
            this.$emit("newButtonClicked")
        },
        EditButtonClicked(id){
         
            this.$emit("EditButtonClicked",id)
        },
        customButtonClicked(row){
          
                this.$emit("customButtonClicked",row)
        },
        previousClicked: function () {

            let previous = this.currentPage - 1;
            if (previous > 0) {
                this.fetchPageData(previous);
            }

            //fetchPageData();
        },
        nextClicked: function () {
            let next = this.currentPage + 1;

            if (this.currentPage < this.pageCount) {
                this.fetchPageData(next);
            }

            //fetchPageData();
        },
        fetchPageData: function (page) {

            this.currentPage = page;
            page = page - 1;
            let dataurl = process.env.VUE_APP_SERVICE_URL + this.PageUrl + "?page=" + page;
            axios.get(dataurl).then((resp) => {
                this.content = resp.data.content

            });

        },
        deleteItem: function (itemId) {
            this.showDeleteModalCounter++;
            this.showDelete=true;
            let deletUrl=process.env.VUE_APP_SERVICE_URL + this.deleteUrl+'/'+itemId;
            
           
           
            this.showDeleteModal = true;

            if(this.showDeleteModal){
                     this.$confirm.require({
                message: 'Are you sure you Delete?',
                header: 'Confirmation',
                icon: 'pi pi-exclamation-triangle',
                accept: () => {
                       this.$vToastify.loader("Please Wait...")
                   axios.get(deletUrl).then(()=>{
                          this.getData();
                          this.showDeleteModal=false;
                         
                          this.$vToastify.stopLoader()
                       this.$vToastify.success("Success","Item Deleted!");
                   }).catch((e)=>{
                       console.log(e)
                          this.$vToastify.stopLoader()
                             this.showDeleteModal=false;
                       this.$vToastify.error("An error occured");
                   })
                 
                },
                reject: () => {
                   
                }
            });
             }
             this.showDeleteModal=false;
       
        },
        getData: function () {

            let dataurl = process.env.VUE_APP_SERVICE_URL + this.PageUrl;
           
            axios.get(dataurl).then((resp) => {
                this.content = resp.data.content
                this.pageCount = resp.data.totalPages;
            });
        }
    },
    created() {
        this.PageUrl = this.url;
        this.getData();
        this.currentPage = 1;
       

    },

    watch: {
        search: function (val) {
            this.PageUrl = this.url + '?data=' + val;
            this.getData();

        }
    }

};
</script>
