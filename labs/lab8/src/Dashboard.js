import { useState } from "react";
import PostDetails from "./components/PostDetails";
import Posts from "./containers/Posts";
import NewPost from "./components/NewPost";

const Dashboard = () => {
    const [fetchFlag, setFetchFlag] = useState(true);
    const [selectedState, setSelectedState] = useState(0);
    const changeFetchFlag = () => {
        setFetchFlag(!fetchFlag);
    }
    const setSelected = (id) => {
        setSelectedState(id);
    }

    return ( 
        <div className="header">
            <Posts setSelected={setSelected} fetchFlag={fetchFlag}/>
            <div>
                <PostDetails id={selectedState} changeFetchFlag={changeFetchFlag} />
            </div>
            <div>
                <NewPost changeFetchFlag={changeFetchFlag} />
            </div>
        </div>
     );
}

export default Dashboard;