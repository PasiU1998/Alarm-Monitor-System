import React, {Component} from 'react';
import {Card} from "react-bootstrap";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import FetchData from "./FetchData";

class SensorBox extends Component {

    createTable = () => {
        let table =[]

        for (let i=0 ; i<1; i++){
            let children = []

            for (let j=0 ; j<3 ; j++){
                children.push(
                    <Card bg={this.props.status === '0'
                        ?
                        'light'
                        :
                        this.props.status === '1' && this.props.co2Level < 5 && this.props.smokeLevel < 5
                            ?
                            'success'
                            :
                            'danger'
                    } style={{width: '18rem'}}>

                        {/*<Card bg={this.props.status == "1" ? 'primary' : 'danger'} style={{width: '18rem'}}>*/}
                        <Card.Header><h3>{'Sensor ID: ' + this.props.id}</h3></Card.Header>
                        <Card.Body>

                            <Card.Title>{'Sensor Status : '}{ this.props.status ==="1" ? 'Active' : 'Inactive' }</Card.Title>
                            <Card.Text>{'Floor Number: ' + this.props.floorNumber} </Card.Text>
                            <Card.Text> {'Room Number: ' + this.props.roomNumber}</Card.Text>
                            <Card.Text>{'Smoke Level: ' + this.props.smokeLevel}</Card.Text>
                            <Card.Text>{'CO2 Level: ' + this.props.co2Level}</Card.Text>

                        </Card.Body>
                    </Card>
                )
            }

            table.push(<Row className='test'>{children}</Row>)
        }
        return table;
    }




    render() {
        return (

            <Container>

                <table>
                    {this.createTable()}
                </table>


                {/*<Row>*/}
                    {/*<Col>*/}


                    {/*<Card bg={this.props.status === '0'*/}
                    {/*    ?*/}
                    {/*    'light'*/}
                    {/*    :*/}
                    {/*    this.props.status === '1' && this.props.co2Level < 5 && this.props.smokeLevel < 5*/}
                    {/*        ?*/}
                    {/*        'success'*/}
                    {/*        :*/}
                    {/*        'danger'*/}
                    {/*} style={{width: '18rem'}}>*/}






                    {/*    /!*<Card bg={this.props.status == "1" ? 'primary' : 'danger'} style={{width: '18rem'}}>*!/*/}
                    {/*    <Card.Header><h3>{'Sensor ID: ' + this.props.id}</h3></Card.Header>*/}
                    {/*    <Card.Body>*/}

                    {/*        <Card.Title>{'Sensor Status : '}{ this.props.status ==="1" ? 'Active' : 'Inactive' }</Card.Title>*/}
                    {/*        <Card.Text>{'Floor Number: ' + this.props.floorNumber} </Card.Text>*/}
                    {/*        <Card.Text> {'Room Number: ' + this.props.roomNumber}</Card.Text>*/}
                    {/*        <Card.Text>{'Smoke Level: ' + this.props.smokeLevel}</Card.Text>*/}
                    {/*        <Card.Text>{'CO2 Level: ' + this.props.co2Level}</Card.Text>*/}

                    {/*    </Card.Body>*/}
                    {/*</Card>*/}


                    {/*</Col>*/}


                {/*</Row>*/}


            </Container>


        );
    }
}

export default SensorBox;
