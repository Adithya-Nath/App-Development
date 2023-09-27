
import React, { useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { addApplication, editApplication, removeApplication } from '../Redux/applicationSlice';
import { Table, Button, Modal, Form } from 'react-bootstrap';
import '../Assets/css/donor.css'
function Donor() {
  
  const applications = useSelector((state) => state.applications);
  const dispatch = useDispatch();

  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState({});
  const [editIndex, setEditIndex] = useState(-1);

  const handleShow = () => {
    setShowModal(true);
  };

  const handleClose = () => {
    setShowModal(false);
    setFormData({});
    setEditIndex(-1);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = () => {
    if (editIndex === -1) {
      dispatch(addApplication(formData));
    } else {
      dispatch(editApplication({ index: editIndex, updatedApplication: formData }));
    }
    handleClose();
  };

  const handleEdit = (index) => {
    setFormData(applications[index]);
    setEditIndex(index);
    handleShow();
  };

  const handleRemove = (index) => {
    dispatch(removeApplication(index));
  };

  return (
    <div className="container">
      <h1>Blood Donation Details</h1>
      <Button variant="primary" onClick={handleShow}>
        Add Details
      </Button>
      <Table striped bordered hover className="mt-3">
        <thead>
          <tr>
            <th>Name</th>
            <th>Blood Type</th>
            <th>Age</th>
            <th>Weight</th>
            <th>Haemoglobin Level</th>
            <th>Pulse</th>
            <th>Blood Pressure</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {applications.map((app, index) => (
            <tr key={index}>
              <td>{app.name}</td>
              <td>{app.bloodtype}</td>
              <td>{app.age}</td>
              <td>{app.Weight}</td>
              <td>{app.haemoglobinlevel}</td>
              <td>{app.pulse}</td>
              <td>{app.bloodpressure}</td>
              <td>
                <Button variant="info" onClick={() => handleEdit(index)}>
                  Add
                </Button>
                <Button variant="danger" onClick={() => handleRemove(index)}>
                  Remove
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      <Modal show={showModal} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>{editIndex === -1 ? 'Add Application' : 'Edit Application'}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group controlId="name">
              <Form.Label>Name</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Name"
                name="name"
                value={formData.name || ''}
                onChange={handleInputChange}
              />
            </Form.Group>
            <Form.Group controlId="bloodtype">
              <Form.Label>Blood Type</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Blood Type"
                name="bloodtype"
                value={formData.bloodtype || ''}
                onChange={handleInputChange}
              />
            </Form.Group>
            <Form.Group controlId="age">
              <Form.Label>Age</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Age"
                name="age"
                value={formData.age || ''}
                onChange={handleInputChange}
              />
            </Form.Group>
            <Form.Group controlId="weight">
              <Form.Label>Weight</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Weight"
                name="weight"
                value={formData.weight || ''}
                onChange={handleInputChange}
              />
            </Form.Group>
            <Form.Group controlId="haemoglobin">
              <Form.Label>Haemoglobin Level</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Haemoglobin level"
                name="haemoglobin"
                value={formData.haemoglobin || ''}
                onChange={handleInputChange}
              />
            </Form.Group>
            <Form.Group controlId="pulse">
              <Form.Label>Pulse</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Pulse"
                name="pulse"
                value={formData.pulse || ''}
                onChange={handleInputChange}
              />
            </Form.Group>
            <Form.Group controlId="pgCollegeName">
              <Form.Label>Blood Pressure</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Blood Pressure"
                name="bloodpressure"
                value={formData.bloodpressure || ''}
                onChange={handleInputChange}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmit}>
            {editIndex === -1 ? 'Add' : 'Save Changes'}
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
}

export default Donor;
