import "./newRoom.scss";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import DriveFolderUploadOutlinedIcon from "@mui/icons-material/DriveFolderUploadOutlined";
import {useEffect, useState} from "react";
import { roomInputs } from "../../formSource";
import useFetch from "../../hooks/useFetch";
import axios from "axios";
import {FormControl, Input, MenuItem, Rating, Select} from "@mui/material";
import {useNavigate} from "react-router-dom";
import $api from "../../http";

const NewRoom = () => {

  const [room, setRoom] = useState({});
  const [hotels, setHotels] = useState([]);

  const [hotel, setHotel] = useState(1);
  const [rating, setRating] = useState();

  const navigate = useNavigate();

  useEffect(() => {
    $api.get("/hotels")
        .then(response => {
          setHotels(response.data)
        })
        .catch(reason => {
          //toastr.error("Bookstore", "Виникли технічні проблеми");
        });
  }, []);

  const handleChange = (e) => {
    setRoom((prev) => ({ ...prev, [e.target.id]: e.target.value }));
  };

  const handleClick = async (e) => {
    e.preventDefault();
    try {
      const newroom = {
        ...room,
        hotelId: hotel,
        rating: rating
      };

      await $api.post("/rooms", newroom);

      navigate("/rooms");
    } catch (err) {
      console.log(err)
    }
  };

  return (
    <div className="new">
      <Sidebar />
      <div className="newContainer">
        <Navbar />
        <div className="top">
          <h1>Додавання номеру</h1>
        </div>
        <div className="bottom">
          <div className="right">
            <form>
              <div className="formInput">
                <label>Готель</label>
                <FormControl sx={{m: 1, minWidth: 120}} size="small">
                  <Select
                      id="hotelId"
                      value={hotel}
                      onChange={e => setHotel(e.target.value)}
                      style={{width: 200}}
                  >
                    {
                        hotels &&
                        hotels.map((hotel) => (
                            <MenuItem key={hotel.id} value={hotel.id}>
                              {hotel.name}
                            </MenuItem>
                        ))
                    }
                  </Select>
                </FormControl>
              </div>
              <div className="formInput">
                <label>Ціна</label>
                <Input
                    id={"price"}
                    type={"text"}
                    placeholder="200"
                    onChange={handleChange}
                />
              </div>
              <div className="formInput">
                <label>Rating</label>
                <Rating
                    id="rating"
                    value={hotel.rating}
                    onChange={e => setRating(e.target.value)}
                />
              </div>
              <div className="formInput">
                <label>Кількість людей</label>
                <Input
                    id={"countPeople"}
                    type={"text"}
                    onChange={handleChange}
                />
              </div>
              <div className="formInput">
                <label>Додаткова інформація</label>
                <Input
                    id={"description"}
                    type={"text"}
                    multiline
                    placeholder="Додаткова інформація"
                    onChange={handleChange}
                />
              </div>
              <div className="formInput">
                <label>Кількість номерів</label>
                <Input
                    id={"count"}
                    type={"text"}
                    onChange={handleChange}
                />
              </div>
              <button onClick={handleClick}>Send</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default NewRoom;
