import React, { useState, useEffect } from 'react';
import GroupService from './GroupService';
import { Link } from 'react-router-dom';

const GroupListComponent = () => {
    const [groups, setGroups] = useState([]);

    useEffect(() => {
        GroupService.getAllGroups().then((res) => {
            setGroups(res.data);
        });
    }, []);

    return (
        <div>
            <h2 className="text-center">Group List</h2>
            <div className="row">
                <Link to="/add-group" className="btn btn-primary">Add Group</Link>
            </div>
            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Group id</th>
                            <th>Group Name</th>
                            <th>Group Address</th>
                            <th>Group City</th>
                            <th>Group State/Province</th>
                            <th>Group Country</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {groups.map(group => (
                            <tr key={group.id}>
                                <td>{group.id}</td>
                                <td>{group.name}</td>
                                <td>{group.address}</td>
                                <td>{group.city}</td>
                                <td>{group.state_Or_Province}</td>
                                <td>{group.country}</td>
                                <td>
                                    <Link to={`/update-group/${group.id}`} className="btn btn-info">Update</Link>
                                    <button className="btn btn-danger" onClick={() => GroupService.deleteGroup(group.id).then(() => setGroups(groups.filter(g => g.id !== group.id)))}>Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default GroupListComponent;
