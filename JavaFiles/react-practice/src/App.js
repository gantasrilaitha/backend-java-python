import logo from './logo.svg';
import React, { Component } from 'react';
import './App.css';
import {BrowserRouter , Routes, Route} from 'react-router-dom';
import Navbar from './components/layout/Navbar';
import Users from './components/users/Users';
import User from './components/users/User';
import Search from './components/users/Search';
import axios from 'axios';
import Home from './components/pages/Home';
import About from './components/pages/About';
import GithubState from './context/github/GithubState';

class App extends Component {
  state={
    users:[],
    loading:false,
    user:{}
  };
  async componentDidMount() {
    this.setState({loading: true});
   
      const res = await axios.get('https://api.github.com/users');
      this.setState({users: res.data, loading: false});
    
  }

  //search specific github user
  searchUsers=async (text)=>{
    console.log(text);
    this.setState({loading: true});
    const res = await axios.get(`https://api.github.com/search/users?q=${text}`);
    this.setState({users: res.data.items, loading: false});
    console.log(this.state.users);
  }

  //clear users from state
  clearUsers= ()=>{
    this.setState({users: [], loading:false});

  }

  //get single user
  getUser=async (username)=>{
    this.setState({loading: true});
    const res = await axios.get(`https://api.github.com/users/${username}`);
    this.setState({user: res.data, loading: false});
  }
  
  render(){
    const{users,loading,user}=this.state;
  return (
    <GithubState>
    <BrowserRouter>
    <div>
      <Navbar />
      <Routes>
      <Route exact path='/' element={<Home 
         
         searchUsers={this.searchUsers}
         clearUsers={this.clearUsers}
         showClear={this.state.users.length>0?true:false}
         users={this.state.users}
         loading={this.state.loading}
       
      />} />
      <Route exact path='/about' element={<About />}/>
      <Route exact path='/user/:login' element={<User
          getUser={this.getUser} user={user} loading={loading}
      />} />
       {/* <Search searchUsers={this.searchUsers} clearUsers={this.clearUsers} showClear={this.state.users.length>0?true:false}/>
      <Users  loading={this.state.loading} users={this.state.users}/>  */}
      </Routes>
    </div>
    </BrowserRouter>
    </GithubState>
  );
}
};

export default App;
