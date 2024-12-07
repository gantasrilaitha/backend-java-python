import React, { Component ,useState,useContext} from 'react';
import GithubContext from '../../context/github/GithubContext';
//import alertContext from '../../context/alert/alertContext';
import PropTypes from 'prop-types';
const Search = () => {
    const githubContext = useContext(GithubContext);
    // const alertContext = useContext(alertContext);
    const [text, setText] = useState('');
    const [alert, setAlert] = useState('');

    const onSubmit = e => {
        e.preventDefault();
        if (text .trim()=== '') {
            setAlert('Please enter something', 'light');
            console.log(alert);
          }
        else{
          githubContext.searchUsers(text.trim());
            setText('');
            setAlert(''); // Clear the alert
        }
      };

    return (
        <div>
          <form onSubmit={onSubmit} className='form'>
            <input
              type='text'
              name='text'
              placeholder='Search Users...'
              value={text}
              onChange={ (e) => setText(e.target.value)}
              />
              <input
                type='submit'
                value='Search'
                className='btn btn-dark btn-block'
                />
            </form>
            {githubContext.users.length > 0 &&(
            <button
                className='btn btn-light btn-block'
                onClick={githubContext.clearUsers}>
                Clear
            </button>)}
        </div>
    )
}
Search.propTypes = {
    searchUsers: PropTypes.func.isRequired,
    clearUsers: PropTypes.func.isRequired,
    showClear: PropTypes.bool.isRequired,
};
export default Search;