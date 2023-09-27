// BloodDonationDetails.js
import React, { useState, useEffect } from 'react';
import { Table, Button, Modal, Form } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import { setBloodDonationData, selectBloodDonationData } from '../Redux/BloodSlice'; // Updated import statements

function Recepient() {
  const dispatch = useDispatch();
  const bloodDonationData = useSelector(selectBloodDonationData);

  const [showModal, setShowModal] = useState(false);

  const [formData, setFormData] = useState({
    donorName: '',
    district: '',
    state: '',
    bloodGroup: '',
    age: '',
  });

  useEffect(() => {
    if (bloodDonationData) {
      setFormData(bloodDonationData);
    }
  }, [bloodDonationData]);

  const handleShow = () => {
    setShowModal(true);
  };

  const handleClose = () => {
    setShowModal(false);
  };

  const handleEdit = () => {
    setShowModal(true);
  };

  const handleSave = () => {
    dispatch(setBloodDonationData(formData));
    setShowModal(false);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  return (
    <div>
      <h2>Recepient Details</h2>
      {bloodDonationData ? (
        <>
          <Table striped bordered hover className="mt-3">
            <thead>
              <tr>
                <th>Recepient Name</th>
                <th>District</th>
                <th>State</th>
                <th>Blood Group</th>
                <th>Age</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{bloodDonationData.donorName}</td>
                <td>{bloodDonationData.district}</td>
                <td>{bloodDonationData.state}</td>
                <td>{bloodDonationData.bloodGroup}</td>
                <td>
                  <div className='b1'>
                  <Button variant="info" onClick={handleEdit}>
                    Add
                  </Button>
                  </div>
                </td>
              </tr>
            </tbody>
          </Table>
        </>
      ) : (
        <div>
          <Table striped bordered hover className="mt-3">
            <thead>
              <tr>
                <th>Recepient Name</th>
                <th>District</th>
                <th>State</th>
                <th>Blood Group</th>
                <th>Age</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                  <Button variant="info" onClick={handleEdit}>
                    Edit
                  </Button>
                </td>
              </tr>
            </tbody>
          </Table>
        </div>
      )}

      <Modal show={showModal} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>{bloodDonationData ? 'Edit Blood Donation Details' : 'Add Blood Donation Details'}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group controlId="donorName">
              <Form.Label>Recepient Name</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Recepient Name"
                name="donorName"
                value={formData.donorName || ''}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="district">
              <Form.Label>District</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter District"
                name="district"
                value={formData.district || ''}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="state">
              <Form.Label>State</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter State"
                name="state"
                value={formData.state || ''}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="bloodGroup">
              <Form.Label>Blood Group</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Blood Group"
                name="bloodGroup"
                value={formData.bloodGroup || ''}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="age">
              <Form.Label>Age</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Age"
                name="age"
                value={formData.age || ''}
                onChange={handleChange}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSave}>
            {bloodDonationData ? 'Save Changes' : 'Add'}
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
}

export default Recepient;
