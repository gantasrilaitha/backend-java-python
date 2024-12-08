import React, { useState } from 'react';
import GroupService from './GroupService';
import { useNavigate } from 'react-router-dom';

const AddGroupComponent = () => {
    const [name, setName] = useState('');
    const [address, setAddress] = useState('');
    const [city, setCity] = useState('');
    const [stateOrProvince, setStateOrProvince] = useState('');
    const [country, setCountry] = useState('');
    const navigate = useNavigate();

    const saveGroup = (e) => {
        e.preventDefault();
        const group = { name, address, city, stateOrProvince, country };
        GroupService.createGroup(group).then(() => {
            navigate('/groups');
        });
    };

    return (
        <div>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Add Group</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> Group Name: </label>
                                    <input placeholder="Name" name="name" className="form-control"
                                        value={name} onChange={(e) => setName(e.target.value)} />
                                </div>
                                <div className="form-group">
                                    <label> Group Address: </label>
                                    <input placeholder="Address" name="address" className="form-control"
                                        value={address} onChange={(e) => setAddress(e.target.value)} />
                                </div>
                                <div className="form-group">
                                    <label> Group City: </label>
                                    <input placeholder="City" name="city" className="form-control"
                                        value={city} onChange={(e) => setCity(e.target.value)} />
                                </div>
                                <div className="form-group">
                                    <label> State/Province: </label>
                                    <input placeholder="State/Province" name="stateOrProvince" className="form-control"
                                        value={stateOrProvince} onChange={(e) => setStateOrProvince(e.target.value)} />
                                </div>
                                <div className="form-group">
                                    <label> Group Country: </label>
                                    <input placeholder="Country" name="country" className="form-control"
                                        value={country} onChange={(e) => setCountry(e.target.value)} />
                                </div>
                                <button className="btn btn-success" onClick={saveGroup}>Save</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddGroupComponent;
