// services of react_java project that includes grup,users & events

import axios from 'axios';

const GROUP_API_BASE_URL = "http://localhost:8080/api/";

class GroupService {
    // Get all groups
    async getAllGroups() {
        const res=await axios.get(GROUP_API_BASE_URL+"groups");
        console.log(res);
        return res;
    }

    // Get a group by ID
    async getGroupById(groupId) {
        return await axios.get(`${GROUP_API_BASE_URL}group/${groupId}`);
    }

    // Create a new group
    async createGroup(group) {
        return await axios.post(GROUP_API_BASE_URL+"group", group);
    }

    // Update an existing group
    async updateGroup(group, groupId) {
        return await axios.put(`${GROUP_API_BASE_URL}group/${groupId}`, group);
    }

    // Delete a group by ID
    async deleteGroup(groupId) {
        return await axios.delete(`${GROUP_API_BASE_URL}group/${groupId}`);
    }
}

export default new GroupService();
