import React, { useState, useEffect } from 'react';
import GroupService from './GroupService';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateGroupComponent = () => {
    const { id } = useParams();
    const [name, setName] = useState('');
    const [address, setAddress] = useState('');
    const [city, setCity] = useState('');
    const [state_Or_Province, setState_Or_Province] = useState('');
    const [country, setCountry] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        GroupService.getGroupById(id).then((res) => {
            const group = res.data;
            setName(group.name);
            setAddress(group.address);
            setCity(group.city);
            setState_Or_Province(group.state_Or_Province);
            setCountry(group.country);
        });
    }, [id]);

    const updateGroup = (e) => {
        e.preventDefault();
        const group = { id,name, address, city, state_Or_Province, country };
        GroupService.updateGroup(group, id).then(() => {
            navigate('/groups');
        });
    };

    return (
        <div>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Update Group</h3>
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
                                    <input placeholder="State/Province" name="state_Or_Province" className="form-control"
                                        value={state_Or_Province} onChange={(e) => setState_Or_Province(e.target.value)} />
                                </div>
                                <div className="form-group">
                                    <label> Group Country: </label>
                                    <input placeholder="Country" name="country" className="form-control"
                                        value={country} onChange={(e) => setCountry(e.target.value)} />
                                </div>
                                <button className="btn btn-success" onClick={updateGroup}>Save</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default UpdateGroupComponent;
