import React, {Component} from 'react';
import {Col, Navbar, Row} from "react-bootstrap";
import SensorTable from "./SensorTable";
import Table from "react-bootstrap/Table";

class FetchData extends Component {


    state = {
        sensors: [],
        theme: null
    };


    async componentDidMount() {
        this.intervalId = setInterval(() => this.getData(), 1000 * 60 * 10);
        this.getData();

    };


    getData() {
        const url = 'http://localhost:9090/API/Service/AlamMonitor';
        fetch(url).then(response => response.json())
            .then(sensors => (this.setState({sensors})));
        console.log(this.state.sensors[0]);
    }

    render() {
        return (


            <div>


                <div>


                    <Navbar bg="dark" variant="dark">
                        <Navbar.Brand className=''>
                            Sensor Dashboard
                        </Navbar.Brand>
                    </Navbar>


                    <Row style={{width: '100%'}}>
                        <Col className="col-12 col-md-4 bg-success">
                            Active Normal Sensors
                        </Col>

                        <Col className="col-12 col-md-4 bg-danger">
                            Warning Sensors
                        </Col>

                        <Col className="col-12 col-md-4 bg-secondary">
                            Inactive Sensors
                        </Col>

                    </Row>


                </div>


                {/*Card of Table contents*/}


                <div className="mainCompo">
                    <div className='card tableCard custom-scrollbar-css'>

                        <Table table-hover striped bordered responsive className="displayTable">
                            <thead>
                            <tr className="bg-primary">
                                <th>ID</th>
                                <th>Status</th>
                                <th>Floor Number</th>
                                <th>Room Number</th>
                                <th>Smoke Level</th>
                                <th>CO2 Level</th>
                            </tr>
                            </thead>
                            <tbody>
                            {

                                this.state.sensors.map((Sensor, index) =>
                                    <SensorTable
                                        id={Sensor.SENSOR_ID}
                                        status={Sensor.SENSOR_STATUS}
                                        floorNumber={Sensor.FLOOR_NUMBER}
                                        roomNumber={Sensor.ROOM_NUMBER}
                                        smokeLevel={Sensor.SMOKE_LEVEL}
                                        co2Level={Sensor.CO2_LEVEL}
                                    />
                                )
                            }

                            </tbody>
                        </Table>

                    </div>
                </div>


            </div>
        );
    }
}

export default FetchData;
