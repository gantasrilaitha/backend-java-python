import React, { useReducer } from 'react';
import axios from 'axios';

import GithubContext from './GithubContext';

import GithubReducer from './githubReducer';
import {
  SEARCH_USERS,
  SET_LOADING,
  CLEAR_USERS,
  GET_USER,
  
} from '../types';



const GithubState = props => {
  const initialState = {//state of all props
    users: [],
    user: {},
    repos: [],
    loading: false
  };

  const [state, dispatch] = useReducer(GithubReducer, initialState);

  // Search Users
  const searchUsers = async text => {
    setLoading();

    const res = await axios.get(
      `https://api.github.com/search/users?q=${text}`
    );

    dispatch({//sends to reducer
      type: SEARCH_USERS,
      payload: res.data.items
    });
  };

  // Get User
  const getUser = async username => {
    setLoading();

    const res = await axios.get(
      `https://api.github.com/users/${username}`
    );

    dispatch({
      type: GET_USER,
      payload: res.data
    });
  };

  // Get Repos
  

  // Clear Users
  const clearUsers = () => dispatch({ type: CLEAR_USERS });

  // Set Loading
  const setLoading = () => dispatch({ type: SET_LOADING });

  return (//provider contains response from reducer
    <GithubContext.Provider
      value={{
        users: state.users,
        user: state.user,
        repos: state.repos,
        loading: state.loading,
        searchUsers,
        clearUsers,
        getUser,
        setLoading,
        dispatch
      }}
    >
      {props.children}
    </GithubContext.Provider>
  );
};

export default GithubState;