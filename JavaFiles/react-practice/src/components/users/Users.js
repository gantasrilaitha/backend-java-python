import React, { Component , useContext } from 'react';
import UserItem from './UserItem';
import Spinner from '../layout/Spinner';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import GithubContext from '../../context/github/GithubContext';
const Users = () =>  {

  const githubContext = useContext(GithubContext);

  const { loading, users } = githubContext;
    // state={
    //     users:[
    //         {
    //             id: 1,
    //             login: "mojombo",
    //             avatar_url: "https://avatars.githubusercontent.com/u/1?v=4",
    //             html_url: "https://github.com/mojombo",
    //         },
    //         {   login: "defunkt",
    //             id: 2,
    //             avatar_url: "https://avatars.githubusercontent.com/u/2?v=4",
    //             html_url: "https://github.com/defunkt",

    //         }
    //     ]
    // }


    if (loading) {
        return <Spinner />;
      } else {
        return (
            <div style={userStyle}>
            {users.map((user) => (
              <div key={user.id}>
                <UserItem user={user} />
                
              </div>
            ))}
          </div>
        );
      }
};

const userStyle={
    display: 'grid',
    gridTemplateColumns: 'repeat(3 ,1fr)',
    gridGap: '1rem',
    
}

Users.prpTypes ={
    users:PropTypes.array.isRequired,
    loading:PropTypes.bool.isRequired,
}
export default Users;