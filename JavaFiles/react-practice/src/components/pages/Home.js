import React, { Fragment } from 'react';
import Search from '../users/Search';
import Users from '../users/Users';

const Home = () => {
    return (
      <div className="container">
        <Search
          // searchUsers={searchUsers}
          // clearUsers={clearUsers}
          // showClear={showClear}
        />
        <Users 
        // loading={loading} users={users} 
        />
      </div>
    );
  };

export default Home;